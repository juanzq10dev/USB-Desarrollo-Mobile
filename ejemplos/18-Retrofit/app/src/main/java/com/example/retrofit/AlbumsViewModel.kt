package com.example.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AlbumsViewModel(val albumsRepository: AlbumsRepository): ViewModel() {
    var albumsList = MutableLiveData<ArrayList<Album>>()
    var errorMessage = MutableLiveData<String>()
    fun getAlbums () = viewModelScope.launch {
        albumsRepository.getAlbumByUserId(2).collect {response ->
            if (response.isSuccess) {
                // update albums list
                response.result.let { albums -> // response.body().let = if (response.body != null)
                    albumsList.value = albums!!
                }
            } else {
                errorMessage.value = "Something went wrong, error code ${response.errorCode} "
                /*
                if (response.errorCode == 700) {
                             } else {
                    // Mostrar tipo de erro
                }
                 */
                    // Mostrar error de code 700

            }
        }
    }
}