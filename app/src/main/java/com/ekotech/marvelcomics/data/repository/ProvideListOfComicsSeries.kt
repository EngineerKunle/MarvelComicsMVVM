package com.ekotech.marvelcomics.data.repository

import com.ekotech.marvelcomics.data.api.domain.ComicsSeries

interface ProvideListOfComicsSeries {
    suspend fun getComicsSeries(): List<ComicsSeries>
}
