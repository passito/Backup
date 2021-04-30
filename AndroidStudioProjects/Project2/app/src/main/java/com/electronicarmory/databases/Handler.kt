package com.electronicarmory.databases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Handler : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler)

        var passname = intent.getStringExtra("texto")
        val finalText = findViewById<TextView>(R.id.clickhere)

        finalText.text = "Hello $passname, click NEXT to continue"

        val nextButton = findViewById<Button>(R.id.handler)
        nextButton.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }
    }
}