package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.Item

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Scaffold() {
                modify()
            }
        }
    }
}

@Preview
@Composable
private fun modify() {
    LazyColumn(modifier = Modifier.fillMaxWidth()
        .padding(4.dp)
    ) {
        itemsIndexed(listOf(Cats("Kolya", R.drawable.image),
            Cats("Misha", R.drawable.image),
            Cats("Oleg", R.drawable.image))){ index, item ->
            Item(item)
        }
    }
}
