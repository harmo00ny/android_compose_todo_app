package com.marysugar.android_compose_todo_app.ui.main

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel,
) {
    Text(text = "Hello !")
}