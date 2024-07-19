package com.example.retrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import retrofit2.create

class AlbumsViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlbumsViewModel::class.java)) {
            val albumsApiService = RetrofitFactory.getInstace().create(AlbumApiService::class.java)
            val repository = AlbumsRepository(albumsApiService)
            return AlbumsViewModel(repository) as T
        }
        return super.create(modelClass)
    }
}