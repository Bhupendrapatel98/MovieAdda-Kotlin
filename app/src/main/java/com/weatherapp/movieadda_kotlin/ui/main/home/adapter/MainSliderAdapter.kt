package com.weatherapp.movieadda_kotlin.ui.main.home.adapter

import com.weatherapp.movieadda_kotlin.data.pojo.home.UpcomingMovies
import com.weatherapp.movieadda_kotlin.data.utils.Constant
import ss.com.bannerslider.adapters.SliderAdapter
import ss.com.bannerslider.viewholder.ImageSlideViewHolder

class MainSliderAdapter(var list: List<UpcomingMovies.Result>) : SliderAdapter() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindImageSlide(position: Int, imageSlideViewHolder: ImageSlideViewHolder?) {
        imageSlideViewHolder?.bindImageSlide(Constant.Image_Org+list.get(position).backdrop_path)
    }
}