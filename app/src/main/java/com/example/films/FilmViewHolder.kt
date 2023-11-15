package com.example.films

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView


class FilmViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {

 private val title = itemView.findViewById<TextView>(R.id.title)
private val poster = itemView.findViewById<ImageView>(R.id.poster)
 private val description = itemView.findViewById<TextView>(R.id.description)
    fun bind(film : Film) {
        title.text = film.title
        poster.setImageResource(film.poster)
        description.text = film.description
    }

}