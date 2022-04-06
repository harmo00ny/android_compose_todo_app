package com.marysugar.android_compose_todo_app

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marysugar.android_compose_todo_app.ui.create.CreateToDoScreen
import com.marysugar.android_compose_todo_app.ui.create.CreateToDoViewModel
import com.marysugar.android_compose_todo_app.ui.detail.ToDoDetailScreen
import com.marysugar.android_compose_todo_app.ui.detail.ToDoDetailViewModel
import com.marysugar.android_compose_todo_app.ui.edit.EditToDoScreen
import com.marysugar.android_compose_todo_app.ui.edit.EditToDoViewModel
import com.marysugar.android_compose_todo_app.ui.main.MainScreen
import com.marysugar.android_compose_todo_app.ui.main.MainViewModel
import com.marysugar.android_compose_todo_app.ui.theme.ToDoAppTheme

@Composable
fun ToDoApp() {
    val navController = rememberNavController()

    ToDoAppTheme {
        NavHost(navController = navController, startDestination = "main") {
            composable("main") {
                val viewModel = hiltViewModel<MainViewModel>()
                MainScreen(navController = navController, viewModel = viewModel)
            }
            // 作成画面
            composable("create") {
                val viewModel = hiltViewModel<CreateToDoViewModel>()
                CreateToDoScreen(navController = navController, viewModel = viewModel)
            }
            // 詳細画面
            composable("detail/{todoId}") { backStackEntry ->
                val viewModel = hiltViewModel<ToDoDetailViewModel>()
                val todoId = backStackEntry.arguments?.getString("todoId")?.toInt() ?: 0
                ToDoDetailScreen(navController = navController, viewModel = viewModel, todoId = todoId)
            }
            // 編集画面
            composable("edit/{todoId}") { backStackEntry ->
                val viewModel = hiltViewModel<EditToDoViewModel>()
                val todoId = backStackEntry.arguments?.getString("todoId")?.toInt() ?: 0
                EditToDoScreen(navController = navController, viewModel = viewModel, todoId = todoId)
            }
        }
    }
}