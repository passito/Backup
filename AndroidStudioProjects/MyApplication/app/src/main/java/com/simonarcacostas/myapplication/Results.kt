package com.simonarcacostas.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Results : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)


        val win = intent.getStringExtra("winner")
        val champ = findViewById<TextView>(R.id.Winner)
        champ.text = win

    }

    fun playAgain(view: View) {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
}