package com.example.films

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.alpha
import androidx.core.view.ViewCompat
import androidx.core.view.ViewCompat.animate
import androidx.recyclerview.widget.RecyclerView


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