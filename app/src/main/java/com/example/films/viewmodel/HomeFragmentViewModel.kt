package com.example.films.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.films.App
import com.example.films.domain.Film
import com.example.films.domain.Interactor

import javax.inject.Inject

class HomeFragmentViewModel : ViewModel() {
    val filmListLiveData: MutableLiveData<List<Film>> = MutableLiveData()
@Inject
    lateinit var interactor : Interactor
    init {

App.instance.dagger.inject(this)
        interactor.getFilmsFromApi(page = 1, object : ApiCallback {

            override fun onSuccess(films: List<Film>) {
                filmListLiveData.postValue(films)


            }

            override fun onFailure() {

            }
        }
        )


    }


    interface ApiCallback {
        fun onSuccess(films: List<Film>)
        fun onFailure()
    }
}