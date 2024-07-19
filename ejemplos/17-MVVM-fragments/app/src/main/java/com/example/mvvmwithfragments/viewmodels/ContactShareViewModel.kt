package com.example.mvvmwithfragments.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmwithfragments.models.Contact
import com.example.mvvmwithfragments.repositories.ContactRepository
import kotlinx.coroutines.launch

/*
    This class is used to share data from a fragment to other.
 */

class ContactShareViewModel(val repository: ContactRepository): ViewModel() {
    var selectedContact: Contact? = null
    val contacts = repository.contacts

    fun selectContact (contact: Contact) {
        selectedContact = contact
    }

    fun getAllContacts() = viewModelScope.launch {
        repository.getAll().collect() { result ->
            if ( !result ) {
                // show error message
            }


        }
    }
}