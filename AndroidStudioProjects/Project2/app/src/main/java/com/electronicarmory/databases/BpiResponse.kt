package com.electronicarmory.databases
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BpiResponse(
    val Global: BpiObject
)



class BpiObject(


    @SerializedName("TotalConfirmed")
    val TotalConfirmed: String,

    @SerializedName("TotalDeaths")
    val TotalDeaths: String,

    @SerializedName("NewConfirmed")
    val  NewConfirmed: String,

    @SerializedName("NewDeaths")
    val NewDeaths: String,

    @SerializedName("NewRecovered")
    val NewRecovered: String,

    @SerializedName("TotalRecovered")
    val TotalRecovered: String
)
