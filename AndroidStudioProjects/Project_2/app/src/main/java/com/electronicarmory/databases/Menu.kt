package com.electronicarmory.databases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val ToDOButton = findViewById<Button>(R.id.ToDo)
        ToDOButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val JJButton = findViewById<Button>(R.id.JJ)
        JJButton.setOnClickListener {
            val intent = Intent(this, DatabasesJJ::class.java)
            startActivity(intent)
        }
        val ModernButton = findViewById<Button>(R.id.Moderna)
        ModernButton.setOnClickListener {
            val intent = Intent(this, ModernActivity::class.java)
            startActivity(intent)
        }

        val coronaButton = findViewById<Button>(R.id.updates)
        coronaButton.setOnClickListener {
            val intent = Intent(this, FinalActivity::class.java)
            startActivity(intent)
        }
        val launchButton = findViewById<Button>(R.id.button3)
        launchButton.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}