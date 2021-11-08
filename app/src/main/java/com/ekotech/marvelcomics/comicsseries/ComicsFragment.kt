package com.ekotech.marvelcomics.comicsseries

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.ekotech.marvelcomics.R
import com.ekotech.marvelcomics.comicsseries.adapter.SeriesAdapter
import com.ekotech.marvelcomics.databinding.ComicsFragmentBinding
import com.ekotech.marvelcomics.utils.viewBinding
import com.ekotech.marvelcomics.viewmodels.ComicsSeriesViewModel
import com.ekotech.marvelcomics.viewstate.ComicsSeriesViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsFragment : Fragment(R.layout.comics_fragment) {

    private val binding by viewBinding(ComicsFragmentBinding::bind)
    private val viewModel: ComicsSeriesViewModel by activityViewModels()
    private lateinit var seriesAdapter: SeriesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.comicsSeriesState.observe(viewLifecycleOwner, { state ->
            when (state) {
                is ComicsSeriesViewState.Loading -> {
                    binding.comicsFragmentLoadingSpinner.visibility = View.VISIBLE
                }

                is ComicsSeriesViewState.Success -> {
                    binding.comicsFragmentLoadingSpinner.visibility = View.GONE
                    seriesAdapter = SeriesAdapter().apply {
                        this.series = state.data.toMutableList()
                    }

                    binding.comicsFragmentList.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this.context, 2)
                        adapter = seriesAdapter
                    }
                    binding.comicsFragmentLoadingSpinner.visibility = View.GONE
                }

                is ComicsSeriesViewState.Error -> {
                    binding.comicsFragmentLoadingSpinner.visibility = View.GONE
                }
            }
        })
    }
}