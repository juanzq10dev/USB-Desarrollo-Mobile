package com.example.mvvmwithfragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithfragments.models.Contact
import com.example.mvvmwithfragments.viewmodels.ContactDetailViewModel
import com.example.mvvmwithfragments.viewmodels.ContactDetailsViewModelFactory
import com.example.mvvmwithfragments.viewmodels.ContactShareViewModel
import com.example.mvvmwithfragments.viewmodels.ContactViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var contactViewModel: ContactShareViewModel
    lateinit var contactDetailsViewModel: ContactDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val factory = ContactViewModelFactory(applicationContext)
        contactViewModel = ViewModelProvider(this, factory).get(ContactShareViewModel::class.java)

        val detailsFactory = ContactDetailsViewModelFactory(contactViewModel)
        contactDetailsViewModel = ViewModelProvider(this, detailsFactory).get(ContactDetailViewModel::class.java)

    }
}