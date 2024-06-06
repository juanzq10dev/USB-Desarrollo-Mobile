package com.example.solarsystem

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recycler_view)
        val list = listOf(
            Planet("Mercury", 0, R.drawable.mercury),
            Planet("Venus", 0, R.drawable.venus),
            Planet("Earth", 1, R.drawable.earth),
            Planet("Mars", 2, R.drawable.mars),
            Planet("Jupiter", 79, R.drawable.jupiter),
            Planet("Saturn", 83, R.drawable.saturn),
            Planet("Uranus", 27, R.drawable.uranus),
            Planet("Neptune", 14, R.drawable.neptune)
        )

        recyclerView.adapter = RVAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}