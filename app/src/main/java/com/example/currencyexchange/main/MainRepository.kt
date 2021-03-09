package com.example.currencyexchange.main

import com.example.currencyexchange.APIData.GetAPIResponse
import com.example.currencyexchange.APIData.CurrencyConverterResponse
import com.example.currencyexchange.util.Resource
import javax.inject.Inject

class MainRepository @Inject constructor(private val getApiResponse: GetAPIResponse) {
    suspend fun getRates(base: String): Resource<CurrencyConverterResponse> {
        return try {
            val response = getApiResponse.getRatesForConversion(base)
            val result = response.body()
            if(response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch(e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }
}