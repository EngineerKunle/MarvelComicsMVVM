package com.ekotech.marvelcomics.data.api

import com.ekotech.marvelcomics.data.api.domain.Marvel
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {
    @GET("v1/public/series")
    suspend fun getComicSeries(
        @Query("apikey")
        apiKey: String,
        @Query("ts")
        timeStamp: String,
        @Query("hash")
        hash: String,
        @Query("orderBy")
        orderBy: String = "title",
        @Query("titleStartsWith")
        titleStartsWith: String = "avengers",
        @Query("limit")
        limit: Int
    ): Marvel
}
