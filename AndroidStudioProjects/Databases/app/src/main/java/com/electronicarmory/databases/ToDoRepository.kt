package com.electronicarmory.databases

import io.objectbox.Box
import io.objectbox.kotlin.boxFor
import io.objectbox.kotlin.query
import io.objectbox.query.QueryBuilder
import org.greenrobot.eventbus.EventBus

object ToDoRepository {
    private val todoBox: Box<ToDo> = ObjectBox.boxStore.boxFor()


    fun createToDo(title: String, description: String, isDone: Boolean) {
        val currentToDo = ToDo(title = title, description = description, isDone = isDone)
        todoBox.put(currentToDo)

        EventBus.getDefault().post(EventToDoNew())
    }


    fun allToDos(): List<ToDo> {
        return todoBox.all
    }


    fun allNotDoneToDos(): List<ToDo> {
        val query = todoBox.query {
            equal(ToDo_.isDone, false)
            order(ToDo_.title, QueryBuilder.DESCENDING)
        }

        return query.find()
    }

    private val JJBox: Box<JJ> = ObjectBox.boxStore.boxFor()


    fun createJJ(title: String, description: String, isDone: Boolean) {
        val currentJJ = JJ(title = title, description = description, isDone = isDone)
        JJBox.put(currentJJ)

        EventBus.getDefault().post(EventToDoNew())
    }


    fun allJJ(): List<JJ> {
        return JJBox.all
    }

    fun allNotDoneJJ(): List<JJ> {
        val query = JJBox.query {
            equal(JJ_.isDone,false)
            order(JJ_.title, QueryBuilder.DESCENDING)
        }

        return query.find()
    }



}