package com.weatherapp.movieadda_kotlin.ui.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.weatherapp.movieadda_kotlin.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }
}