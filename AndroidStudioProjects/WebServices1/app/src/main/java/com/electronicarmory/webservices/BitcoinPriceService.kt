package com.electronicarmory.webservices

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BitcoinPriceService {
    private val service: CoinDeskApi

    init{
        val retrofit = Retrofit.Builder().
        baseUrl(BuildConfig.WEB_SERVER).
        addConverterFactory(GsonConverterFactory.create()).
        build()
        service = retrofit.create(CoinDeskApi::class.java)
    }

    fun getBitcoinPrice(callback: Callback<BpiResponse>){
        val call = service.getBitcoinPrice()
        call.enqueue(callback)
    }
}