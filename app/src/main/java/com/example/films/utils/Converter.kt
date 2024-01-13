package com.example.films.utils

import com.example.films.data.Entity.TmdFilm
import com.example.films.domain.Film

object Converter {
    fun converterApiListToDtoList(list: List<TmdFilm>?) : List<Film> {
        val result = mutableListOf<Film>()
        list?.forEach {
            result.add(
                Film(title = it.title,
            poster = it.posterPath,
            description = it.overview,
            rating = it.voteAverage,
            isInFavorites = false)
            )
        }
        return result
    }
}