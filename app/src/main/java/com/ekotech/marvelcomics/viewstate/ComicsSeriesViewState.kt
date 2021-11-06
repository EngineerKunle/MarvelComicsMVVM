package com.ekotech.marvelcomics.viewstate

import com.ekotech.marvelcomics.data.api.domain.ComicsSeries

sealed class ComicsSeriesViewState {
    object Loading : ComicsSeriesViewState()
    data class Success(val data: List<ComicsSeries>) : ComicsSeriesViewState()
    data class Error(val message: String) : ComicsSeriesViewState()
}