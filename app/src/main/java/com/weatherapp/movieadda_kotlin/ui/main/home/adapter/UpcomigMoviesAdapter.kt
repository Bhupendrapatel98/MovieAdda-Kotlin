package com.weatherapp.movieadda_kotlin.ui.main.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.weatherapp.movieadda_kotlin.R
import com.weatherapp.movieadda_kotlin.data.pojo.home.TrendingTvShow
import com.weatherapp.movieadda_kotlin.data.pojo.home.UpcomingMovies
import com.weatherapp.movieadda_kotlin.data.utils.Constant

class UpcomigMoviesAdapter(var list: List<UpcomingMovies.Result>) :RecyclerView.Adapter<UpcomigMoviesAdapter.TrendingTvShowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingTvShowViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.trending_movies_item, parent, false)
        return TrendingTvShowViewHolder(v)
    }


    override fun onBindViewHolder(holder: TrendingTvShowViewHolder, position: Int) {

        Picasso.get().load(Constant.IMAGE_BASE_URL+list.get(position).poster_path).into(holder.trending_m_img)
        holder.trending_m_name.text = list.get(position).title
        holder.vote.text = list.get(position).vote_average.toString()
    }

    override fun getItemCount(): Int {
       return list.size
    }

    class TrendingTvShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var trending_m_img: ImageView = itemView.findViewById(R.id.trending_m_img) as ImageView
        var trending_m_name: TextView = itemView.findViewById(R.id.trending_m_name) as TextView
        var vote: TextView = itemView.findViewById(R.id.vote) as TextView
        var main: LinearLayout = itemView.findViewById(R.id.main) as LinearLayout
    }

}