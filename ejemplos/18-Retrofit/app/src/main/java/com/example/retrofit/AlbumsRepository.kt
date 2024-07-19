package com.example.retrofit

import android.util.Log
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response

class AlbumsRepository(val albumApiService: AlbumApiService) {
    fun getAlbum() = flow { // A data String to make async function on a non async way
        val result = albumApiService.getAlbum()
        emit(result) // all places subscribed to this receives the result
    }

    fun getAlbumByUserId(userId: Int) = flow {
        try {
            val result = albumApiService.getAlbumsByUserId(userId)
            val processResult = processResult(result)
        } catch (e: HttpException) {
            emit(MyResponse(null, e.code()))
        } catch (e: Exception) {
            Log.d("AlbumsRepository", e.message.toString())
        }
        // emit(result)


    }

    private fun processResult(response: Response<ArrayList<Album>>): MyResponse<ArrayList<Album>> {
        if (response.isSuccessful && response.body() != null) {
            return MyResponse(response.body(), null)
        } else {
            return  MyResponse(null, 700)
        }
    }
}