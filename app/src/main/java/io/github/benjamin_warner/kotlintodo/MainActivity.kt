package io.github.benjamin_warner.kotlintodo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.ListView
import io.github.benjamin_warner.kotlintodo.ArrayAdapters.TodoAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var newTodoEditText: EditText
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var todoListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newTodoEditText = findViewById(R.id.todo_text) as EditText

        todoAdapter = TodoAdapter(this, R.layout.todo_list_item, ArrayList())
        todoListView = findViewById(R.id.todo_list) as ListView
        todoListView.adapter = todoAdapter

        findViewById(R.id.add_todo).setOnClickListener { addNewToDo() }
    }

    private fun addNewToDo() {
        todoAdapter.addToDo(newTodoEditText.text.toString())
        todoAdapter.notifyDataSetChanged()
    }
}
