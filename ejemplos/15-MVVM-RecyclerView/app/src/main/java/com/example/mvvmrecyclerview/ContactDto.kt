package com.example.mvvmrecyclerview

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDto {
    @Insert
    suspend fun insertContact(contact: Contacts): Long  // suspend is like await of js

    @Update
    suspend fun updateContact(contact: Contacts)

    @Query("SELECT * FROM contacts")
    fun getAllContacts(): LiveData<List<Contacts>>
}