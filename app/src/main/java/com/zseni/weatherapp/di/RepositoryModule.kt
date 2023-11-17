package com.zseni.weatherapp.di

import com.zseni.weatherapp.data.api.RemoteDataSource
import com.zseni.weatherapp.data.local.room.LocalDataSource
import com.zseni.weatherapp.data.repository.WeatherRepoImpl
import com.zseni.weatherapp.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Provides
    fun provideWeatherDataRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ): WeatherRepoImpl {
        return WeatherRepoImpl(localDataSource, remoteDataSource)
    }

}