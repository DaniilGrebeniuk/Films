package com.example.films.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.films.App
import com.example.films.domain.Film
import com.example.films.domain.Interactor

class HomeFragmentViewModel : ViewModel() {
    val filmListLiveData : MutableLiveData<List<Film>> = MutableLiveData()
    private var interactor: Interactor = App.instance.interactor
    init {
        val film = interactor.gerFilmDB()
        filmListLiveData.postValue(film)
    }
}