package com.example.films.di

import com.example.films.di.modules.DatabaseModule
import com.example.films.di.modules.DomainModule
import com.example.films.di.modules.RemoteModule
import com.example.films.viewmodel.HomeFragmentViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
    (
    modules = [
        RemoteModule::class,
        DatabaseModule::class,
        DomainModule::class
    ]
)
interface AppComponent {
fun inject(homeFragmentViewModel: HomeFragmentViewModel)
}