package com.example.mvvmrecyclerview

import androidx.lifecycle.MutableLiveData

class ContactMemoryStore {
    val contacts = MutableLiveData<ArrayList<Contacts>>()

    init {
        contacts.value = arrayListOf(Contacts(1, "Gabriela", "gabi@gmail.com"),
            Contacts(2, "Gavi", "gabi@gmail.com"),
            Contacts(3, "Gabi", "gabi@gmail.com"),
            Contacts(4, "Gabrie", "gabi@gmail.com"),
            Contacts(5, "Gabriel", "gabi@gmail.com"),
        )
    }

    fun inser(contact: Contacts) {
        contact.id = (contacts.value?.size!! ?: 0).toLong()
        contacts.value?.add(contact)
        contacts.value = contacts.value
    }

    fun update(contact: Contacts) {
        contacts.value = contacts.value
    }
}