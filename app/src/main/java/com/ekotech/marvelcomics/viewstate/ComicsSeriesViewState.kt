package com.ekotech.marvelcomics.viewstate

import com.ekotech.marvelcomics.comicsseries.models.SeriesModel

sealed class ComicsSeriesViewState {
    object Loading : ComicsSeriesViewState()
    data class Success(val data: List<SeriesModel>) : ComicsSeriesViewState()
    data class Error(val message: String) : ComicsSeriesViewState()
}