package com.ekotech.marvelcomics.comicsseries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ekotech.marvelcomics.R
import com.ekotech.marvelcomics.comicsseries.models.SeriesModel
import com.ekotech.marvelcomics.utils.autoNotify

class SeriesAdapter : RecyclerView.Adapter<SeriesAdapter.ViewHolder>() {

    var series: MutableList<SeriesModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_series, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(series[position])

    override fun getItemCount(): Int = series.size

    fun setData(updatedSeries: MutableList<SeriesModel>) {
        autoNotify(series, updatedSeries) { oldList, newList ->
            oldList.id == newList.id
        }
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.item_series_title)
        private val seriesImage: ImageView = view.findViewById(R.id.item_series_image)

        fun bind(model: SeriesModel) {
            title.text = model.seriesName


            Glide
                .with(view)
                .load(buildPath(model))
                .centerCrop()
                .error(R.drawable.marvel_phone)
                .into(seriesImage)
        }

        private fun buildPath(model: SeriesModel): String {
            return if (model.thumbnail == null) {
                ""
            } else {
                model.thumbnail.path + "/portrait_incredible." + model.thumbnail.extensions
            }
        }
    }
}