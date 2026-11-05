package com.example.compose

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SecondScreen(
    onClickButton: () -> Unit) {
    Button(onClickButton) {
        Text("Вернуться")
    }
}