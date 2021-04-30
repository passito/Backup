package com.electronicarmory.databases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity2 : AppCompatActivity() {
    lateinit var frameLayout: FrameLayout
    lateinit var newToDoButton: Button
    val todoItemFragment = JJlistFragment.newInstance("1")
    val todoCrudFragment = JJFragment.newInstance(" " , " ")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            val titleString = savedInstanceState.getString("title")
        }

        setContentView(R.layout.activity_main)

        frameLayout = findViewById(R.id.frameLayout)
        newToDoButton = button // findViewById(R.id.button)

        newToDoButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, todoCrudFragment)
                .addToBackStack("add-todo")
                .commit()
        }

        val newAc = findViewById<Button>(R.id.newActivity)
        newAc.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)        }

        supportFragmentManager.beginTransaction()
            .add(R.id.frameLayout, todoItemFragment)
            .commit()

    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.putString("title", "this the title we entered")
    }


    override fun onStart() {
        super.onStart()

        EventBus.getDefault().register(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun newToDo(event: EventToDoNew) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, todoItemFragment)
            .commit()
    }
}