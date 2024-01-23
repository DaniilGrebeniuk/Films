package com.example.films

import android.app.Application
import com.example.films.data.Entity.TmdbApi
import com.example.films.data.MainRepository
import com.example.films.di.AppComponent
import com.example.films.di.DaggerAppComponent
import dagger.internal.DaggerCollections


class App : Application() {
    lateinit var dagger: AppComponent
    override fun onCreate() {
        super.onCreate()
        instance = this
        dagger = DaggerAppComponent.create()


    }



    companion object {
        //Здесь статически хранится ссылка на экземпляр App
        lateinit var instance: App
            //Приватный сеттер, чтобы нельзя было в эту переменную присвоить что-либо другое
            private set
    }

}