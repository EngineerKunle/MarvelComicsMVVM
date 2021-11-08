package com.ekotech.marvelcomics.comicsseries.models

import com.ekotech.marvelcomics.data.api.domain.Thumbnail

data class SeriesModel(
    val id: Int,
    val seriesName: String,
    val description: String?,
    val thumbnail: ThumbnailModel?
)

data class ThumbnailModel(
    val path: String,
    val extensions: String
)