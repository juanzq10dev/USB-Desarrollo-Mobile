package com.example.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
   Rooms needs to have only one instance, Retrofit does not need that.
   It is common to create static mehtods
 */
class RetrofitFactory {
    companion object { // companion defines static objects
        val BASE_URL = "https://jsonplaceholder.typicode.com"
        fun getInstace(): Retrofit {
            return  Retrofit.Builder().baseUrl(BASE_URL).
                addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()
        }
    }
}