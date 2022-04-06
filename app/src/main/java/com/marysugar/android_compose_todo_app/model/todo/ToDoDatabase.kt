package com.marysugar.android_compose_todo_app.model.todo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ToDo::class], version = 1)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun todoDAO(): ToDoDAO
}