package com.example.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun FirstScreen(
    onClickButton: () -> Unit
) {
    var dialogueId by remember {
        mutableIntStateOf(1)
    }

    LaunchedEffect(dialogueId) {
        delay(2000.milliseconds)
        println("Реплика $dialogueId готова")
    }

    Scaffold { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            DialogueScreen(
                dialogueId = dialogueId,
                onNextDialogue = {
                    dialogueId++
                }
            )

            Button(
                onClick = onClickButton
            ) {
                Text("Перейти на второй экран")
            }
        }
    }
}
@Composable
fun DialogueScreen(
    dialogueId: Int,
    onNextDialogue: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Элиза стояла у окна и смотрела на дождь.",
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = "Номер реплики: $dialogueId"
        )

        Button(
            onClick = onNextDialogue
        ) {
            Text("Переход к следующей реплике")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DialogueScreenPreview() {
    ComposeTheme {
        DialogueScreen(
            dialogueId = 1,
            onNextDialogue = { }
        )
    }
}