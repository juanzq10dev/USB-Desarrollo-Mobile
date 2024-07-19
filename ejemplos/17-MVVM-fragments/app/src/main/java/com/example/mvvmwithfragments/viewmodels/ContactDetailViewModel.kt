package com.example.mvvmwithfragments.viewmodels

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmwithfragments.models.Contact
import kotlinx.coroutines.launch

class ContactDetailViewModel(val contactsShareViewModel: ContactShareViewModel): ViewModel()  {
    val repository = contactsShareViewModel.repository
    var contactName = MutableLiveData<String>()
    var contactEmail  = MutableLiveData<String>()
    var isValid = MediatorLiveData<Boolean>()

    init {
        isValid.addSource(contactName) {
            isValid.value = checkIfValid()
        }
        isValid.addSource(contactEmail) {
            isValid.value = checkIfValid()
        }
    }

    fun updateTexts() {
        contactName.value = contactsShareViewModel.selectedContact?.name
        contactEmail.value = contactsShareViewModel.selectedContact?.email
    }

    fun insert(contact: Contact) = viewModelScope.launch {
        repository.insertToApi(contact)
    }

    fun update(contact: Contact) = viewModelScope.launch {
        repository.update(contact)
    }

    fun save() {
        if (contactsShareViewModel.selectedContact == null) {
            if (!(contactName.value).isNullOrBlank() && !(contactEmail.value).isNullOrBlank()) {
                insert(Contact("", contactName.value!!, contactEmail.value!!))
                contactName.value = ""
                contactEmail.value = ""
            }
        } else {
            if (!(contactName.value).isNullOrBlank() && !(contactEmail.value).isNullOrBlank()) {
                contactsShareViewModel.selectedContact?.name = contactName.value!!
                contactsShareViewModel.selectedContact?.email  = contactEmail.value!!
                update(contactsShareViewModel.selectedContact!!)
                contactsShareViewModel.selectedContact = null
                contactName.value = ""
                contactEmail.value = ""
            }
        }
    }

    private fun checkIfValid() = !(contactName.value).isNullOrBlank()  &&
            !(contactEmail.value).isNullOrBlank()
}