package com.ekotech.marvelcomics.data.api

import com.ekotech.marvelcomics.BuildConfig
import com.ekotech.marvelcomics.BuildConfig.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MarvelServiceModule {

    @Provides
    @Singleton
    fun provideHTTPLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): MarvelService = retrofit.create(MarvelService::class.java)

    @Singleton
    @Provides
    fun providesNetworkDefaultsOptions(): NetworkDefaultsOptions = NetworkDefaultsOptions(
        BuildConfig.PUBLIC_KEY,
        BuildConfig.PRIVATE_KEY,
        "12",
        "title",
        "avengers"
    )

    @Singleton
    @Provides
    @HashString
    fun provideHashValue(nwOptions: NetworkDefaultsOptions): String {
        val md = MessageDigest.getInstance("MD5")
        val hashDecoded = nwOptions.timeStamp + nwOptions.privateKey + nwOptions.publicKey
        return BigInteger(1, md.digest(hashDecoded.toByteArray()))
            .toString(16)
            .padStart(32, '0')
    }
}
