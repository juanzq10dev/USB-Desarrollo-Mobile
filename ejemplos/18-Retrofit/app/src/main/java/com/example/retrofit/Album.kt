package com.example.retrofit

import com.google.gson.annotations.SerializedName

class Album(
    @SerializedName("id") // <- Maps the json name ti this value
    val id: Int,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("title")
    val title: String) {
}