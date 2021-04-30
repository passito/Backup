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

    fun deleteToDoALL(){

        todoBox.removeAll()
        EventBus.getDefault().post(EventToDoNew())

    }
    fun deleteToDo(id:Long){
        todoBox.remove(id)
        EventBus.getDefault().post(EventToDoNew())

    }


    fun allToDos(): List<ToDo> {
        return todoBox.all
    }

    fun containsToDo(id:Long): Boolean {
        return todoBox.contains(id)
    }
    fun emptyTodo(): Boolean {
        return todoBox.isEmpty()
        EventBus.getDefault().post(EventToDoNew())

    }


    fun allNotDoneToDos(): List<ToDo> {
        val query = todoBox.query {
            equal(ToDo_.isDone, false)
            order(ToDo_.description, QueryBuilder.DESCENDING)
        }

        return query.find()
    }

    //Modern Data
    private val ModernBox: Box<Modern> = ObjectBox.boxStore.boxFor()


    fun createModern(title: String, description: String, isDone: Boolean) {
        val currentModern = Modern(title = title, description = description, isDone = isDone)
        ModernBox.put(currentModern)

        EventBus.getDefault().post(EventToDoNew())
    }

    fun deleteModernALL(){

        ModernBox.removeAll()
        EventBus.getDefault().post(EventToDoNew())

    }
    fun deleteModern(id:Long){
        ModernBox.remove(id)
        EventBus.getDefault().post(EventToDoNew())

    }


    fun allModern(): List<Modern> {
        return ModernBox.all
    }

    fun containsModern(id:Long): Boolean {
        return ModernBox.contains(id)
    }
    fun emptyModern(): Boolean {
        return ModernBox.isEmpty()
        EventBus.getDefault().post(EventToDoNew())

    }
    fun allNotDoneModern(): List<Modern> {
        val query = ModernBox.query {
            equal(Modern_.isDone, false)
            order(Modern_.title, QueryBuilder.DESCENDING)
        }

        return query.find()
    }



    //JJ Data
    private val JJBox: Box<JJ> = ObjectBox.boxStore.boxFor()


    fun createJJ(title: String, description: String, isDone: Boolean) {
        val currentJJ = JJ(title = title, description = description, isDone = isDone)
        JJBox.put(currentJJ)

        EventBus.getDefault().post(EventToDoNew())
    }

    fun deleteJJALL(){

        JJBox.removeAll()
        EventBus.getDefault().post(EventToDoNew())

    }
    fun deleteJJ(id:Long){
        JJBox.remove(id)
        EventBus.getDefault().post(EventToDoNew())

    }


    fun allJJ(): List<JJ> {
        return JJBox.all
    }

    fun containsJJ(id:Long): Boolean {
        return JJBox.contains(id)
    }
    fun emptyJJ(): Boolean {
        return JJBox.isEmpty()
        EventBus.getDefault().post(EventToDoNew())

    }


    fun allNotDoneJJ(): List<JJ> {
        val query = JJBox.query {
            equal(JJ_.isDone, false)
            order(JJ_.title, QueryBuilder.DESCENDING)
        }

        return query.find()
    }
}