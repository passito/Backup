package com.simonarcacostas.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class RandomNumber : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_number)




        val generate = findViewById<Button>(R.id.button)
        generate.setOnClickListener {

            var from = findViewById<TextView>(R.id.number1)
            var number1 = from.getText().toString().toInt()
            var to = findViewById<TextView>(R.id.number2)
            var number2 = to.getText().toString().toInt()
            var result = findViewById<TextView>(R.id.textView)


            var random = Random.nextInt(number1, number2+1)
            result.text = "$random"

        }




    }


    fun board(view: View) {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }

    fun random(view: View){}

}
