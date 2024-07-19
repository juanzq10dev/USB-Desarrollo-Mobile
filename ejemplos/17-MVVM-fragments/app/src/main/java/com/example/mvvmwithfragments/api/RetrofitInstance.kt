package com.example.mvvmwithfragments.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitInstance {
    companion object {
        val BASE_URL = "https://notes-app-9c438.web.app"
        fun getInstance(): Retrofit {
            return Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create()) // <- Allows to read basic types (Strings, Int, etc)
                .addConverterFactory(GsonConverterFactory.create()) .build() // <- Used to read JSON objects
        }
    }
}