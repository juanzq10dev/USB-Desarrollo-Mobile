package com.example.mvvmwithfragments.repositories

import com.example.mvvmwithfragments.api.ContactsApiService
import com.example.mvvmwithfragments.daos.ContactDao
import com.example.mvvmwithfragments.models.Contact
import kotlinx.coroutines.flow.flow
import retrofit2.awaitResponse


class ContactRepository(private val contactsDao: ContactDao,
                        private val contactsApiService: ContactsApiService) {

    val contacts = contactsDao.getAllContacts()

    suspend fun insert(contact: Contact) {
        contactsDao.insertContact(contact)
    }

    suspend fun update(contact: Contact) {
        contactsDao.updateContact(contact)
    }

    fun getAll() = flow {  // Process async data
        val result = contactsApiService.getContacts()
        // Here goes the internet check.
        if ( result.isSuccessful && result.body() != null) {
            contactsDao.insertAll(result.body()!!)
            emit(true)
        } else {
            emit(false)
        }
    }

    suspend fun insertToApi(contact: Contact) {
        val call = contactsApiService.postContact(contact)
        val response = call.awaitResponse()
        if (response.isSuccessful) {
            getAll().collect() {  // .collect() is the way to recover data from a flow function.

            }
        } else {
            // do something, throw error
        }
    }
}