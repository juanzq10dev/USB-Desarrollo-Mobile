package com.example.mvvmwithfragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.mvvmwithfragments.databinding.ContactCardBinding
import com.example.mvvmwithfragments.models.Contact

class ContactsRecyclerViewAdapter(var contacts: List<Contact>, val clickListener: (Contact) -> Unit): RecyclerView.Adapter<ContactsRecyclerViewAdapter.ContactViewHolder>() {
    inner class ContactViewHolder(val binding: ContactCardBinding): RecyclerView.ViewHolder(binding.root) {

    }

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
        holder.binding.contactCell.setOnClickListener{ clickListener(contact) }
    }
}