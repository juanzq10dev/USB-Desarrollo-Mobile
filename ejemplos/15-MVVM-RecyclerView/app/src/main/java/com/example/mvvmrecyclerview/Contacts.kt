package com.example.mvvmrecyclerview

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contacts(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(name = "contact_name")
    var name: String,
    @ColumnInfo
    var email: String) {

}