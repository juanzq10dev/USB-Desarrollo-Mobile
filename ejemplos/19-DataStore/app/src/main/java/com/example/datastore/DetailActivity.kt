package com.example.datastore

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backgroundView = findViewById<View>(R.id.main)
        val text = findViewById<TextView>(R.id.nameText)

        lifecycleScope.launch(Dispatchers.IO) { // working on couritine
            getUserProfile().collect {
                withContext(Dispatchers.Main) {
                    text.text = it.name
                    if (it.vip) {
                        backgroundView.setBackgroundResource(R.color.black)
                    }

                }
            }
        }
    }

    private fun getUserProfile() = dataStore.data.map { prefences ->
        UserProfile(
            name = prefences[stringPreferencesKey("name")].orEmpty(),
            vip = prefences[booleanPreferencesKey("vip")] ?: false
        )
    }
}