package com.example.retrofit

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: AlbumsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val factory = AlbumsViewModelFactory()
        viewModel = ViewModelProvider.create(this, factory).get(AlbumsViewModel::class.java)
        viewModel.albumsList.observe(this) {
            val albumsList = it.listIterator()
            binding.textView.text = ""
            while (albumsList.hasNext()) {
                val albumItem = albumsList.next()
                val albumText = "Album: ${albumItem.id} ${albumItem.title} \n"
                binding.textView.append(albumText)
            }
        }

        viewModel.errorMessage.observe(this) {
            binding.textView.text = it
        }
        viewModel.getAlbums()


    }
}