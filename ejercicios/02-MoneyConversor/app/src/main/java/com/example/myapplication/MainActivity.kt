package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.math.RoundingMode
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var resText = findViewById<TextView>(R.id.result)
        var inputText = findViewById<EditText>(R.id.input)
        var button = findViewById<Button>(R.id.convert_button)
        button.setOnClickListener {
            resText.text = toDolar(inputText.text.toString().toDouble()).toString() + " $"
        }
    }

    fun toDolar(bs: Double): Double {
        return bs.div(8.01).toBigDecimal().setScale(2, RoundingMode.UP).toDouble();
    }
}