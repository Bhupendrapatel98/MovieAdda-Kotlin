package com.weatherapp.movieadda_kotlin.ui.main.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.weatherapp.movieadda_kotlin.data.pojo.home.TrendingPerson
import com.weatherapp.movieadda_kotlin.data.repo.trending.TrendingRepository

public class HomeViewModel : ViewModel() {

     private  var trerepo: TrendingRepository = TrendingRepository()
     private lateinit var mutable: MutableLiveData<TrendingPerson>

    fun getTrending():LiveData<TrendingPerson> {

        if (this::mutable.isInitialized) {
            return mutable
        }
        else{
            mutable = trerepo.getTrendingPerson()
            return mutable
        }
    }
}