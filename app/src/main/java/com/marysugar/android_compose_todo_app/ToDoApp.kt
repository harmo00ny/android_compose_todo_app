package com.marysugar.android_compose_todo_app

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marysugar.android_compose_todo_app.ui.theme.ToDoAppTheme

@Composable
fun ToDoApp() {
    val navController = rememberNavController()

    ToDoAppTheme {
        NavHost(navController = navController, startDestination = "main") {
            composable("main") {
                Surface(color = MaterialTheme.colors.background) {
                    Greeting(name = "Android")
                }
            }
        }
    }
}