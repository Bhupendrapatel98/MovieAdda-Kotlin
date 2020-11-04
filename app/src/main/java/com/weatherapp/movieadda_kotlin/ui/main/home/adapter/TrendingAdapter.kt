package com.weatherapp.movieadda_kotlin.ui.main.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.weatherapp.movieadda_kotlin.R
import com.weatherapp.movieadda_kotlin.data.pojo.home.TrendingPerson
import com.weatherapp.movieadda_kotlin.data.utils.Constant

class TrendingAdapter(var list: List<TrendingPerson.Result>) : RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false)
        return TrendingViewHolder(v)
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {

        Picasso.get().load(Constant.IMAGE_BASE_URL+list.get(position).profile_path).into(holder.person_profile)
        holder.person_name.text = list.get(position).name
    }

    override fun getItemCount(): Int {
       return list.size
    }

    class TrendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var person_profile :ImageView = itemView.findViewById(R.id.person_profile) as ImageView
        var person_name:TextView = itemView.findViewById(R.id.person_name) as TextView
    }

}