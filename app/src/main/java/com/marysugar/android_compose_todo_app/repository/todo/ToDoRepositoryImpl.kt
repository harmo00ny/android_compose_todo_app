package com.marysugar.android_compose_todo_app.repository.todo

import com.marysugar.android_compose_todo_app.model.todo.ToDo
import com.marysugar.android_compose_todo_app.model.todo.ToDoDAO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoRepositoryImpl @Inject constructor(
    private val dao: ToDoDAO
) : ToDoRepository {
    override suspend fun create(title: String, detail: String): ToDo {
        val todo = ToDo(
            title = title,
            detail = detail,
            created = System.currentTimeMillis(),
            modified = System.currentTimeMillis(),
        )
        dao.create(todo)
        return todo
    }

    override fun getAll(): Flow<List<ToDo>> {
        return dao.getAll()
    }
}