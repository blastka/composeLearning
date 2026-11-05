package com.example.compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.compose.ui.theme.ComposeTheme
import com.example.compose.ui.theme.Item

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTheme(darkTheme = false) {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    AppNavHost(
                        navController,
                        Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
private fun modify() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        itemsIndexed(
            listOf(
                Cats("Kolya", R.drawable.image),
                Cats("Misha", R.drawable.image),
                Cats("Oleg", R.drawable.image)
            )
        ) { index, item ->
            Item(item)
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "Light Mode"
)
@Composable
private fun TestStudyAppHeader() {
    StudyAppHeader("dgdgf", "gfhfhfgh")
}

@Composable
private fun StudyAppHeader(
    title: String,
    subtitle: String
) {
    Column {
        Text(text = title)
        Text(text = subtitle)
    }
}

@Composable
@Preview
fun PrimaryButton() {
    Button(
        shape = RoundedCornerShape(13.dp),
        onClick = {},
        modifier = Modifier
            .height(56.dp)
            .padding(40.dp, 0.dp)
            .fillMaxWidth()
    ) {
        Text(
            "Зарегистрироваться",
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CheckEmailFields() {

    var textState by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = textState,
        onValueChange = {
            textState = it
        },
        shape = RoundedCornerShape(13.dp),
        textStyle = MaterialTheme.typography.headlineMedium,
        singleLine = true,
        label = {
            Text(
                text = "Электропочта",
            )
        }
    )
}