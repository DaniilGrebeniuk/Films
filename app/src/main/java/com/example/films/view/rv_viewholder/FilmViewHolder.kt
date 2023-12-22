package com.example.films.view.rv_viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.films.R
import com.example.films.domain.Film
import com.example.films.view.costomview.RatingDonutView


class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {

    private val title = itemView.findViewById<TextView>(R.id.title)
    private val poster = itemView.findViewById<ImageView>(R.id.poster)
    private val description = itemView.findViewById<TextView>(R.id.description)
    private val ratingDonut = itemView.findViewById<RatingDonutView>(R.id.rating_donut)
    fun bind(film: Film) {
        title.text = film.title
        poster.setImageResource(film.poster)
        description.text = film.description
        ratingDonut.alpha = 0.0f
        ratingDonut.setProgress((film.rating * 10).toInt())
        ratingDonut.animate().apply {
            duration = 2200
            alpha(1f)
            start()
        }
    }
}