package com.example.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumApiService {
    @GET("/albums")
    suspend fun getAlbum(): Response<ArrayList<Album>> // suspend = executes on other thread.

    @GET("/albums")
    suspend fun getAlbumsByUserId(@Query("userId") userId: Int): Response<ArrayList<Album>>

}