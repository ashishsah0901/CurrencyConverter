package com.example.currencyexchange.APIData

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GetAPIResponse {
    @GET("/latest")
    suspend fun getRatesForConversion(
        @Query("base") base: String
    ): Response<CurrencyConverterResponse>
}