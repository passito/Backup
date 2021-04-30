package com.electronicarmory.databases

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CoronaService {
    private val service: CoronaAPI

    init{
        val retrofit = Retrofit.Builder().
        baseUrl(BuildConfig.WEB_SERVER).
        addConverterFactory(GsonConverterFactory.create()).
        build()
        service = retrofit.create(CoronaAPI ::class.java)
    }

    fun getCoronaupdates(callback: Callback<BpiResponse>){
        val call = service.getCoronaUpdates()
        call.enqueue(callback)
    }
}