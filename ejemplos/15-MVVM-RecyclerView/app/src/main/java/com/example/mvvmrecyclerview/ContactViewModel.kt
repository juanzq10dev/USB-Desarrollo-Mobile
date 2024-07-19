package com.example.mvvmrecyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ContactViewModel(val repository: ContactsRepository): ViewModel() {
    var nameText = MutableLiveData<String>()
    var emailText = MutableLiveData<String>()
    var selectedContact: Contacts? = null
    var contacts = repository.contacts

    fun insert(contact: Contacts) = viewModelScope.launch {
        repository.insert(contact)
    }

    fun update(contact: Contacts) = viewModelScope.launch {
        repository.update(contact)
    }

    fun save() {
        if (!nameText.value.isNullOrEmpty() && !emailText.value.isNullOrEmpty()) {
            if (selectedContact != null) {
                update()
            } else {
                create()
            }

            nameText.value = ""
            emailText.value = ""
        }
    }

    fun selectContact(contact: Contacts) {
        selectedContact = contact
        nameText.value = contact.name
        emailText.value = contact.email
    }

    private fun update() {
            selectedContact?.name = nameText.value!!
            selectedContact?.email = emailText.value!!
            update((selectedContact!!))
            selectedContact = null
    }

    private fun create() {
        val newContacts = Contacts(0, nameText.value!!, emailText.value!!)
        insert(newContacts)
    }
}