package com.example.solarsystem

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listViewButton = findViewById<Button>(R.id.button_list_view)
        listViewButton.setOnClickListener{
            val intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        }

        val recyclerButton = findViewById<Button>(R.id.button_recycler_view)
        recyclerButton.setOnClickListener{
            val intent = Intent(this, RecyclerViewActivity:: class.java)
            startActivity(intent)
        }
    }

}