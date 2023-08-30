package com.example.appweather.service

import com.example.appweather.InforWeather
import com.example.appweather.Utils
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("forecast?")
    fun getCurrentWeather(
        @Query("lat")
        lat:String,
        @Query("lon")
        lon:String,
        @Query("appid")
        appid:String = Utils.API_KEY
    ):Call<InforWeather>

    @GET("forecast?")
    fun getWeatherByCity(
        @Query("q")
        city:String,
        @Query("appid")
        appid:String = Utils.API_KEY
    ):Call<InforWeather>

}