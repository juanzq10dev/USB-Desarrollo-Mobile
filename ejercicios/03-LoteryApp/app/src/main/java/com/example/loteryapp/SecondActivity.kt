package com.example.loteryapp

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {

    private fun generateLottoNumbersText(totalNumbers: Int): String {
        var res = ""
        for (i in 0..totalNumbers) {
            res += Random.nextInt(0, 100).toString() + " "
        }
        return res.trim()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var button = findViewById<Button>(R.id.share_button)
        var lottoNum = findViewById<TextView>(R.id.numbers_text_view)
        lottoNum.text = generateLottoNumbersText(6)
        var userName = intent.getStringExtra("user_name")

        button.setOnClickListener{
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "I am $userName my lotto number is: " + lottoNum.text.toString())
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent)
        }
    }
}