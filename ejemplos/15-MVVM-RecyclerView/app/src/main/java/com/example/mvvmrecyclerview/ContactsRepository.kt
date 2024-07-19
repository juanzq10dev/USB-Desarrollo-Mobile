package com.example.mvvmrecyclerview

class ContactsRepository(val contactDto: ContactDto) {
    val contacts = contactDto.getAllContacts()

    suspend fun insert(contact: Contacts) {
        contactDto.insertContact(contact)
    }

    suspend fun update(contact: Contacts) {
        contactDto.updateContact(contact)
    }
}