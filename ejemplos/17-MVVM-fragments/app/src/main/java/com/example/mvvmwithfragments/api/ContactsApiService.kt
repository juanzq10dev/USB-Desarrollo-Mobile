package com.example.mvvmwithfragments.api

import com.example.mvvmwithfragments.models.Contact
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ContactsApiService {
    @GET("/contacts")
    suspend fun getContacts(): Response<ArrayList<Contact>>

    @POST("/contacts")
    suspend fun postContact(@Body contact: Contact): Call<String>
}