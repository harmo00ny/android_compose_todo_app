package com.marysugar.android_compose_todo_app

import android.content.Context
import androidx.room.Room
import com.marysugar.android_compose_todo_app.model.todo.ToDoDAO
import com.marysugar.android_compose_todo_app.model.todo.ToDoDatabase
import com.marysugar.android_compose_todo_app.repository.todo.ToDoRepository
import com.marysugar.android_compose_todo_app.repository.todo.ToDoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindToDoRepository(impl: ToDoRepositoryImpl): ToDoRepository
}

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    @Singleton
    fun provideToDoDatabase(@ApplicationContext context: Context): ToDoDatabase {
        return Room.databaseBuilder(
            context,
            ToDoDatabase::class.java,
            "todo.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideToDoDAO(db: ToDoDatabase): ToDoDAO {
        return db.todoDAO()
    }
}