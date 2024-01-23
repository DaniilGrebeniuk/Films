package com.example.films.domain

import com.example.films.data.Entity.ApiConstants
import com.example.films.data.Entity.TmdbApi
import com.example.films.data.Entity.TmdbResultsDto
import com.example.films.data.MainRepository
import com.example.films.utils.Converter
import com.example.films.viewmodel.HomeFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi) {
    fun getFilmsFromApi(page: Int, callback: HomeFragmentViewModel.ApiCallback) {

        retrofitService.getFilms(ApiConstants.KEY, "ru-RU", page)
            .enqueue(object : Callback<TmdbResultsDto> {
                override fun onResponse(
                    call: Call<TmdbResultsDto>,
                    response: Response<TmdbResultsDto>
                ) {
                    //При успехе мы вызываем метод передаем onSuccess и в этот коллбэк список фильмов
                    callback.onSuccess(Converter.converterApiListToDtoList(response.body()?.tmdFilms))

                }

                override fun onFailure(call: Call<TmdbResultsDto>, t: Throwable) {
                    callback.onFailure()
                }

            })
    }

}