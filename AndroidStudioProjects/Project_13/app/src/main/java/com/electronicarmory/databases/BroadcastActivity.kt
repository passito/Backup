package com.electronicarmory.databases

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.greenrobot.eventbus.EventBus

class BroadcastActivity : AppCompatActivity() {
    lateinit var broadcastButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)

        broadcastButton = findViewById(R.id.broadcastButton)

        broadcastButton.setOnClickListener {
            val editTextTextPersonName = findViewById<EditText>(R.id.editTextTextPersonName)
            val name:String = editTextTextPersonName.text.toString()
            if (name.isEmpty()){
                editTextTextPersonName.error = "Enter name please";

            }else {
                EventBus.getDefault().post(RadioEvent(name))
                finish()
            }
        }
    }
}