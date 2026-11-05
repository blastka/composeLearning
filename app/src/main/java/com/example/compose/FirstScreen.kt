package com.example.compose

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun FirstScreen(
    onClickButton: () -> Unit) {
    Button(onClick = { onClickButton() }) {
        Text("Перейти на второй экран")
    }
}