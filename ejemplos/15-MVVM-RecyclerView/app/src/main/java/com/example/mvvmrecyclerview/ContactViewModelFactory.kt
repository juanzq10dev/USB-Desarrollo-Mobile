package com.example.mvvmrecyclerview

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ContactViewModelFactory(val context: Context): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom(ContactViewModel::class.java)) {
           val database = ContactDatabase.getInstance(context)
           val dao = database.contactDto
           val contactsRepository = ContactsRepository(dao)
           return ContactViewModel(contactsRepository) as T
       }
        return super.create(modelClass)
    }
}