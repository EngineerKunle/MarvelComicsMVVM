package com.ekotech.marvelcomics.data.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ComicSeriesModule {

    @Singleton
    @Binds
    abstract fun bindsComicRepository(repo: ComicSeriesRepository): ProvideListOfComicsSeries

}