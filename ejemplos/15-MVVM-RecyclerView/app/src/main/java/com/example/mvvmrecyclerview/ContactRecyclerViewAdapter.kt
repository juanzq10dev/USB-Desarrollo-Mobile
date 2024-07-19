package com.example.mvvmrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmrecyclerview.databinding.ContactCardBinding

class ContactRecyclerViewAdapter(var contacts: List<Contacts>, var clickListener: (Contacts) -> Unit): RecyclerView.Adapter<ContactRecyclerViewAdapter.ContactViewHolder>() {
    inner class ContactViewHolder(val binding: ContactCardBinding): RecyclerView.ViewHolder(binding.root) { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ContactCardBinding.inflate(inflater, parent, false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.binding.contact = contact
        holder.binding.contactCard.setOnClickListener {
            clickListener(contact)
        }
    }

    fun updateContacts(contacts: List<Contacts>) {
        this.contacts = contacts
        notifyDataSetChanged()
    }
}