package com.electronicarmory.databases

import retrofit2.Call
import retrofit2.http.GET

interface CoronaAPI {
    @GET("summary")
    fun getCoronaUpdates(): Call<BpiResponse>
}
