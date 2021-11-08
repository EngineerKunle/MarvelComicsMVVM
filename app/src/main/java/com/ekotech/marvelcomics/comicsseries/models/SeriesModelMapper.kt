package com.ekotech.marvelcomics.comicsseries.models

import com.ekotech.marvelcomics.data.api.domain.ComicsSeries
import com.ekotech.marvelcomics.data.api.domain.Thumbnail
import javax.inject.Inject

class SeriesModelMapper @Inject constructor() {

    fun transform(items: List<ComicsSeries>) = items.map {
        SeriesModel(
            it.id,
            it.seriesName,
            it.description,
            convertToThumbnailModel(it.thumbnail)
        )
    }

    private fun convertToThumbnailModel(item: Thumbnail?) = ThumbnailModel(item!!.path, item.extension)
}