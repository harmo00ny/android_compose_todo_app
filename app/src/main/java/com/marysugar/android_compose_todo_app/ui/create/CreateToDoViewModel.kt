package com.marysugar.android_compose_todo_app.ui.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marysugar.android_compose_todo_app.repository.todo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class CreateToDoViewModel @Inject constructor(
    private val repo: ToDoRepository
) : ViewModel() {

    val errorMessage = MutableStateFlow("")
    val done = MutableStateFlow(false)

    fun save(title: String, detail: String) {
        if (title.trim().isEmpty()) {
            errorMessage.value = "Input title"
            return
        }
        viewModelScope.launch {
            try {
                repo.create(title, detail)
                done.value = true
            } catch (e: Exception) {
                errorMessage.value = e.message ?: ""
            }
        }
    }
}