package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            opa()
        }
    }

}

@Composable
private fun opa(){
        Column(modifier = Modifier
            .background(Color.LightGray) // фон
            .fillMaxSize(), // заполнить все
            verticalArrangement = Arrangement.SpaceAround, // текст расположен относительно друг друга по вертикали
            horizontalAlignment = Alignment.End) { // как будет текст расположен относительно друг друга по горизонтали
            Text(text = "Hello")
            Text(text = "Hello")
            Text(text = "Hello")
        }
}

@Preview
@Composable
private fun opa1(){
    Row(modifier = Modifier.fillMaxSize().background(Color.LightGray),
        horizontalArrangement = Arrangement.SpaceEvenly) {
        Column(
            modifier = Modifier.fillMaxHeight(0.5f),
            verticalArrangement = Arrangement.SpaceAround, // текст расположен относительно друг друга по вертикали
            horizontalAlignment = Alignment.End
        ) { // как будет текст расположен относительно друг друга по горизонтали
            Text(text = "Hello")
            Text(text = "Hello")
            Text(text = "Hello")
        }
        Column(
            modifier = Modifier.fillMaxHeight(0.5f),
            verticalArrangement = Arrangement.SpaceAround, // текст расположен относительно друг друга по вертикали
            horizontalAlignment = Alignment.Start
        ) { // как будет текст расположен относительно друг друга по горизонтали
            Text(text = "Hello")
            Text(text = "Hello")
            Text(text = "Hello")
        }
    }
}