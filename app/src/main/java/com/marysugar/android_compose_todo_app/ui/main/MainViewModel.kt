package com.marysugar.android_compose_todo_app.ui.main

import androidx.lifecycle.ViewModel
import com.marysugar.android_compose_todo_app.repository.todo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repo: ToDoRepository
) : ViewModel() {
    val todoList = repo.getAll()
}