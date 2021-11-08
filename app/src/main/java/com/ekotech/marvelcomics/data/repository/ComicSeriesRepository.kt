package com.ekotech.marvelcomics.data.repository

import com.ekotech.marvelcomics.data.api.HashString
import com.ekotech.marvelcomics.data.api.MarvelService
import com.ekotech.marvelcomics.data.api.NetworkDefaultsOptions
import com.ekotech.marvelcomics.data.api.domain.ComicsSeries
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ComicSeriesRepository @Inject constructor(
    private val marvelService: MarvelService,
    @HashString private val hashValue: String,
    private val networkOptions: NetworkDefaultsOptions
) : ProvideListOfComicsSeries {

    override suspend fun getComicsSeries(): List<ComicsSeries> {
        return withContext(Dispatchers.IO) {
            marvelService.getComicSeries(networkOptions.publicKey, networkOptions.timeStamp, hashValue, limit = networkOptions.limit).data.results
        }
    }
}
