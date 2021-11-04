package com.ekotech.marvelcomics.viewstate

sealed class ComicsViewState {
    object Loading : ComicsViewState()
    data class Success(val state: String) : ComicsViewState()
    data class Error(val message: String) : ComicsViewState()
}