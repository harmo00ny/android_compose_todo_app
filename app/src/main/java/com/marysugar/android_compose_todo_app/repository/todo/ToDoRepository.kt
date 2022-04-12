package com.marysugar.android_compose_todo_app.repository.todo

import com.marysugar.android_compose_todo_app.model.todo.ToDo

interface ToDoRepository {
    suspend fun create(title: String, detail: String): ToDo
}