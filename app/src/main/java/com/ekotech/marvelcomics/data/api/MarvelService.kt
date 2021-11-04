package com.ekotech.marvelcomics.data.api

import retrofit2.http.GET

interface MarvelService {
    @GET("v1/public/series")
    suspend fun getComicSeries()
}