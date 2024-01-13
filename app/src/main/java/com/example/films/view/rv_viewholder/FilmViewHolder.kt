package com.example.films.view.rv_viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.annotation.GlideOption
import com.example.films.R
import com.example.films.data.Entity.ApiConstants
import com.example.films.domain.Film
import com.example.films.view.costomview.RatingDonutView


class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title = itemView.findViewById<TextView>(R.id.title)
    private val poster = itemView.findViewById<ImageView>(R.id.poster)
    private val description = itemView.findViewById<TextView>(R.id.description)
    private val ratingDonut = itemView.findViewById<RatingDonutView>(R.id.rating_donut)
    fun bind(film: Film) {
        title.text = film.title
        Glide.with(itemView)
            .load(ApiConstants.IMAGES_URL + "w342" + film.poster)
            .centerCrop()
            .into(poster)

        description.text = film.description
        //ratingDonut.alpha = 0.0f
        ratingDonut.setProgress((film.rating * 10).toInt())
        /*ratingDonut.animate().apply {
            duration = 2200
            alpha(1f)
            start()


        }*/
    }
}