package com.marysugar.android_compose_todo_app.ui.main

import android.text.format.DateFormat
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.marysugar.android_compose_todo_app.R
import com.marysugar.android_compose_todo_app.model.todo.ToDo

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel,
) {
    val todoList = viewModel.todoList.collectAsState(emptyList())
    Scaffold(
        topBar = { MainTopBar() },
        floatingActionButton = { MainFAB(navController) }
    ) {
        ToDoList(todoList) { todo ->
            println(it)
        }
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
fun ToDoList(list: State<List<ToDo>>, itemSelected: (todo: ToDo) -> Unit) {
    LazyColumn {
        items(list.value) { todo ->
            ToDoListItem(todo, itemSelected)
        }
    }
}

@Composable
fun ToDoListItem(todo: ToDo, itemSelected: (todo: ToDo) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            todo.title,
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            DateFormat.format("yyyy-MM-dd hh:mm:ss", todo.created).toString(),
            style = MaterialTheme.typography.body2
        )
    }
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