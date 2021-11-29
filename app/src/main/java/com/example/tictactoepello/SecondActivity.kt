package com.example.tictactoepello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var button :Button
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        button = findViewById(R.id.button)

        var extras = intent.extras
        var name = extras?.getString("player") ?: "Pippo"
        println(name)

        textView = findViewById(R.id.textView)
        if (name != "none")
            textView.text = getString(R.string.winner, name)
        else
            textView.text = getString(R.string.draw)

        button.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}