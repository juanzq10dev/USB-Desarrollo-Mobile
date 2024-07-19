package com.example.datastore

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// Example get of: https://www.youtube.com/watch?v=9x_FmyLkDZ8
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user") // Declared this way, this is a singleton
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

        val buttonSave = findViewById<Button>(R.id.buttonSave)
        val editText = findViewById<EditText>(R.id.nameText)
        val checkbox = findViewById<CheckBox>(R.id.checkbox)

        buttonSave.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) { // Defines where does runs the coroutine
                saveValues(editText.text.toString(), checkbox.isChecked)
            }

            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }
    }

    private suspend fun saveValues(name: String, isVip: Boolean) { // dataStore works with coroutines so needs to be suspend
        dataStore.edit { preference ->
            preference[stringPreferencesKey("name")] = name
            preference[booleanPreferencesKey("vip")] = isVip
        }
    }
}