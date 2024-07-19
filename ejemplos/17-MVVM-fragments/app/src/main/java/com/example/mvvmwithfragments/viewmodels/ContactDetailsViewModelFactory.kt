package com.example.mvvmwithfragments.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.SharedFlow

class ContactDetailsViewModelFactory(val sharedViewModel: ContactShareViewModel): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactDetailViewModel::class.java)) {
            return ContactDetailViewModel(sharedViewModel) as T

        }
        return super.create(modelClass)
    }
}