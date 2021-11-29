package com.example.tictactoepello

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {

    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        button = findViewById(R.id.start_button)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply{

                var p1: EditText = findViewById(R.id.input_p1)
                var p2: EditText = findViewById(R.id.input_p2)

                putExtra("Name_1", p1.text.toString())
                putExtra("Name_2", p2.text.toString())
            }
            startActivity(intent)
        }
    }
}