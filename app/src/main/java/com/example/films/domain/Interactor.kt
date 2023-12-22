package com.example.films.domain

import com.example.films.data.MainRepository

class Interactor(val repo : MainRepository) {
    fun gerFilmDB() : List<Film> = repo.filmDataBase

}