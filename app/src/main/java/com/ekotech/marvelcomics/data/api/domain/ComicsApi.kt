package com.ekotech.marvelcomics.data.api.domain

import com.google.gson.annotations.SerializedName

data class ComicsApi(
    private val id: Int,
    @SerializedName("title")
    private val seriesName: String,
    private val description: String?,
    private val thumbnail: Thumbnail?
)

data class Thumbnail(
    private val path: String,
    private val extension: String
)
