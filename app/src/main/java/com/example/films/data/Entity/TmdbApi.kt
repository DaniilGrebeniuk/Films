package com.example.films.data.Entity

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApi {
    @GET("movie/popular")
    fun getFilms(
        @Query("api_key") apiKey : String,
        @Query("language") language : String,
        @Query("page") page : Int,
    ): Call<TmdbResultsDto>
}