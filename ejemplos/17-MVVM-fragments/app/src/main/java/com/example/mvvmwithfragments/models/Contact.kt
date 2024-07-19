package com.example.mvvmwithfragments.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("contacts")
data class Contact(
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @ColumnInfo
    @SerializedName("name")
    var name: String,
    @ColumnInfo
    @SerializedName("email")
    var email: String)