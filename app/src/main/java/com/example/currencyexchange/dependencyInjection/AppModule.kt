package com.example.currencyexchange.dependencyInjection

import com.example.currencyexchange.APIData.GetAPIResponse
import com.example.currencyexchange.main.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideCurrencyApi(): GetAPIResponse = Retrofit.Builder()
        .baseUrl("https://api.exchangeratesapi.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(GetAPIResponse::class.java)

    @Singleton
    @Provides
    fun provideMainRepository(getApiResponse: GetAPIResponse): MainRepository = MainRepository(getApiResponse)

}