package com.ekotech.marvelcomics.data.api.domain

import com.google.gson.annotations.SerializedName

data class Marvel(
    @SerializedName("data")
    val data: MarvelData
)

data class MarvelData(
    @SerializedName("results")
    val results: List<ComicsSeries>
)

data class ComicsSeries(
    val id: Int,
    @SerializedName("title")
    val seriesName: String,
    val description: String?,
    val thumbnail: Thumbnail?
)

data class Thumbnail(
    val path: String,
    val extension: String
)
