package com.example.mvvmwithfragments.viewmodels

import android.content.Context
import androidx.lifecycle.HasDefaultViewModelProviderFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithfragments.api.ContactsApiService
import com.example.mvvmwithfragments.api.RetrofitInstance
import com.example.mvvmwithfragments.repositories.ContactRepository
import com.example.mvvmwithfragments.repositories.ContactsAppDatabase
import retrofit2.create

class ContactViewModelFactory(val context: Context): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactShareViewModel::class.java)) {
            val database = ContactsAppDatabase.getInstance(context)
            val contactDao = database.contactDao
            val contactsApiService = RetrofitInstance.getInstance()
                .create(ContactsApiService::class.java)
            val contactRepository = ContactRepository(contactDao, contactsApiService)
            return ContactShareViewModel(contactRepository) as T
        }
        return super.create(modelClass)
    }
 }