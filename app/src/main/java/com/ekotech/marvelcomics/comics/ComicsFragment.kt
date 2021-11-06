package com.ekotech.marvelcomics.comics

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ekotech.marvelcomics.R
import com.ekotech.marvelcomics.viewmodels.ComicsSeriesViewModel
import com.ekotech.marvelcomics.viewstate.ComicsSeriesViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsFragment : Fragment(R.layout.comics_fragment) {
    private val viewModel: ComicsSeriesViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.comicsSeriesState.observe(viewLifecycleOwner, { state ->
            when (state) {
                is ComicsSeriesViewState.Loading -> println("Loading")
                is ComicsSeriesViewState.Success -> println("Success")
                is ComicsSeriesViewState.Error -> println("Error")
            }
        })
    }
}