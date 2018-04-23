package com.example.android.quizzkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start_btn = findViewById<Button>(R.id.start_quiz)

        start_btn.setOnClickListener{
            val intent = Intent(this,quiz::class.java)
            startActivity(intent)
        }

    }
}
