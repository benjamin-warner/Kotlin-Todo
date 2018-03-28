package io.github.benjamin_warner.kotlintodo.ArrayAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import io.github.benjamin_warner.kotlintodo.R

class TodoAdapter(context: Context?, resource: Int, todos: ArrayList<String>) : ArrayAdapter<String>(context, resource, todos) {

    private var todos: ArrayList<String> = todos

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {

        val view: View?
        val item = getItem(position)

        if(convertView == null){
            val layoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.todo_list_item, parent, false)
        }
        else{
            view = convertView
        }

        val todoText = view?.findViewById(R.id.todo_text) as TextView
        todoText.text = item

        view.findViewById(R.id.remove_todo).setOnClickListener{ removeToDo(item) }

        return view
    }

    private fun removeToDo(item: String) {
        todos.remove(item)
        notifyDataSetChanged()
    }

    fun addToDo(text: String){
        todos.add(text)
        notifyDataSetChanged()
    }
}
