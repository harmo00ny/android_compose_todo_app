package com.marysugar.android_compose_todo_app.ui.main

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.marysugar.android_compose_todo_app.R

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel,
) {
    Scaffold(
        topBar = { MainTopBar() },
        floatingActionButton = { MainFAB(navController) }
    ) {

    }
}

@Composable
fun MainTopBar() {
    TopAppBar(
        title = {
            Text(stringResource(id = R.string.app_name))
        },
    )
}

@Composable
fun MainFAB(navController: NavController) {
    FloatingActionButton(onClick = {
        // 作成画面へ画面遷移
        navController.navigate("create")
    }) {
        Icon(Icons.Filled.Add, "Add")
    }
}