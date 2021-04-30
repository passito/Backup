package com.electronicarmory.databases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class ModernActivity : AppCompatActivity() {
    lateinit var frameLayout: FrameLayout
    lateinit var newToDoButton: Button
    lateinit var deleteButton: Button

    private val todoItemFragment = ModernItemFragment.newInstance("1")
    private val todoCrudFragment = ModernCrudFragment.newInstance(" " , " ")
    private val deleteCrudFragment = DeleteModeFragment.newInstance("","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            val titleString = savedInstanceState.getString("title")
        }

        setContentView(R.layout.activity_main)

        frameLayout = findViewById(R.id.frameLayout)
        newToDoButton = findViewById(R.id.button)

        newToDoButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, todoCrudFragment)
                .addToBackStack("add-todo")
                .commit()
        }

        deleteButton = findViewById(R.id.Delete)
        deleteButton.setOnClickListener {
            if (ToDoRepository.emptyTodo()) {

            }else {

                supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, deleteCrudFragment)
                    .addToBackStack("add-todo")
                    .commit()
            }
        }
        val launchButton = findViewById<Button>(R.id.Return)
        launchButton.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            startActivity(intent)
        }


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