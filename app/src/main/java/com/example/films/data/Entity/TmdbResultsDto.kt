package com.example.films.data.Entity

import com.google.gson.annotations.SerializedName

data class TmdbResultsDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val tmdFilms: List<TmdFilm>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)