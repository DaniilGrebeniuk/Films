package com.example.films.di.modules

import com.example.films.data.Entity.TmdbApi
import com.example.films.data.MainRepository
import com.example.films.domain.Interactor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {
    @Singleton
    @Provides
    fun provideInteractor(repository: MainRepository,tmdbApi: TmdbApi) = Interactor(repo = repository, retrofitService = tmdbApi)
}