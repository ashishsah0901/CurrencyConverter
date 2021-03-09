package com.example.currencyexchange.APIData

data class CurrencyConverterResponse(
    val base: String,
    val date: String,
    val rates: Rates
)