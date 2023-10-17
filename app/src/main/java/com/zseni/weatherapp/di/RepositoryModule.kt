package com.zseni.weatherapp.di

import com.zseni.weatherapp.data.repository.WeatherRepoImpl
import com.zseni.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton

    abstract fun bindWeatherRepository(weatherRepoImpl: WeatherRepoImpl):WeatherRepository

}