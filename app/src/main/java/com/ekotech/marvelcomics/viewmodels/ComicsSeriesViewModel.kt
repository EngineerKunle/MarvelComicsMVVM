package com.ekotech.marvelcomics.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekotech.marvelcomics.data.usecase.GetComicSeries
import com.ekotech.marvelcomics.viewstate.ComicsSeriesViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComicsSeriesViewModel @Inject constructor(private val getComicSeries: GetComicSeries) : ViewModel() {

    private val _comicsSeriesState = MutableLiveData<ComicsSeriesViewState>(ComicsSeriesViewState.Loading)
    val comicsSeriesState = _comicsSeriesState

    init {
        loadComicsSeries()
    }

    private fun loadComicsSeries() {
        viewModelScope.launch {
            try {
                getComicSeries().let { series ->
                    series.forEach {
                        print(it.seriesName)
                    }
                    _comicsSeriesState.value = ComicsSeriesViewState.Success(series)
                }
            } catch (e: Exception) {
                _comicsSeriesState.value = ComicsSeriesViewState.Error("Error!!!")
            }
        }
    }

}