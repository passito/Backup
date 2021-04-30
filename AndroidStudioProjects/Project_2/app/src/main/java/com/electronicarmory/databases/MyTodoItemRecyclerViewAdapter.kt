package com.electronicarmory.databases

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * [RecyclerView.Adapter] that can display a [ToDo].
 * TODO: Replace the implementation with code for your data type.
 */
class MyTodoItemRecyclerViewAdapter(
    private val values: List<ToDo>
) : RecyclerView.Adapter<MyTodoItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item:ToDo = values[position]
        holder.idView.text = item.id.toString()
        holder.titleView.text = item.title
        holder.contentView.text = item.description.toString()
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.textID)
        val titleView: TextView = view.findViewById(R.id.item_number)
        val contentView: TextView = view.findViewById(R.id.content)

        override fun toString(): String {
            return super.toString() + "'" + contentView.text + "'"
        }
    }
}