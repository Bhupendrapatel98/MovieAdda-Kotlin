package com.weatherapp.movieadda_kotlin.ui.main.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.weatherapp.movieadda_kotlin.R
import com.weatherapp.movieadda_kotlin.data.repo.trending.TrendingRepository
import com.weatherapp.movieadda_kotlin.ui.main.home.adapter.TrendingAdapter
import com.weatherapp.movieadda_kotlin.ui.main.home.adapter.TrendingMoviesAdapter
import com.weatherapp.movieadda_kotlin.ui.main.home.adapter.TrendingTvShowAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):
            View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)


        val vmodel = HomeViewModel()

        //get Trending Person
        vmodel.getTrending().observe(this, Observer {

            trending_person_recycler?.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            val trendingAdapter = TrendingAdapter(it.results)
            trending_person_recycler?.adapter = trendingAdapter
        })

        //get Trending Movies
        vmodel.getTrendingMovie().observe(this, Observer {

            trending_recycler?.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            val trendingMoviesAdapter = TrendingMoviesAdapter(it.results)
            trending_recycler?.adapter = trendingMoviesAdapter
        })

        //get Trending Movies
        vmodel.getTrendingTvShow().observe(this, Observer {


            trending_tvs_recycler?.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            val trendingTvShowAdapter = TrendingTvShowAdapter(it.results)
            trending_tvs_recycler?.adapter = trendingTvShowAdapter
        })

        return view
    }
}