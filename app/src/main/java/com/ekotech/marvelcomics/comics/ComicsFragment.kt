package com.ekotech.marvelcomics.comics

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ekotech.marvelcomics.R

class ComicsFragment : Fragment(R.layout.comics_fragment) {
    private val viewModel: ComicsViewModel by activityViewModels()
}