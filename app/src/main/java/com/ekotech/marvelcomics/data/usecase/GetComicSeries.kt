package com.ekotech.marvelcomics.data.usecase

import com.ekotech.marvelcomics.data.repository.ComicSeriesRepository
import javax.inject.Inject

class GetComicSeries @Inject constructor(private val repository: ComicSeriesRepository) {
    suspend operator fun invoke() = repository.getComicsSeries()
}
