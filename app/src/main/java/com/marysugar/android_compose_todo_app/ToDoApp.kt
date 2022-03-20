package com.marysugar.android_compose_todo_app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marysugar.android_compose_todo_app.ui.create.CreateToDoScreen
import com.marysugar.android_compose_todo_app.ui.detail.ToDoDetailScreen
import com.marysugar.android_compose_todo_app.ui.edit.EditToDoScreen
import com.marysugar.android_compose_todo_app.ui.main.MainScreen
import com.marysugar.android_compose_todo_app.ui.theme.ToDoAppTheme

@Composable
fun ToDoApp() {
    val navController = rememberNavController()

    ToDoAppTheme {
        NavHost(navController = navController, startDestination = "main") {
            composable("main") {
                MainScreen(navController = navController)
            }
            // 作成画面
            composable("create") {
                CreateToDoScreen(navController = navController)
            }
            // 詳細画面
            composable("detail/{todoId}") { backStackEntry -> 
                val todoId = backStackEntry.arguments?.getString("todoId")?.toInt() ?: 0
                ToDoDetailScreen(navController = navController, todoId = todoId)
            }
            // 編集画面
            composable("edit/{todoId}") { backStackEntry ->
                val todoId = backStackEntry.arguments?.getString("todoId")?.toInt() ?: 0
                EditToDoScreen(navController = navController, todoId = todoId)
            }
        }
    }
}