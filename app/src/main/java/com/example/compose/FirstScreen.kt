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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme
import kotlinx.coroutines.Job
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun FirstScreen(
    onClickButton: () -> Unit
) {
    var dialogueId by remember {
        mutableIntStateOf(1)
    }

    var isTransitioning by remember {
        mutableStateOf(false)
    }

    var transitionJob by remember {
        mutableStateOf<Job?>(null)
    }

    val scope = rememberCoroutineScope()

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
                isTransitioning = isTransitioning,
                onNextDialogue = {
                    if (!isTransitioning) {
                        isTransitioning = true

                        transitionJob = scope.launch {
                            try {
                                delay(500L.milliseconds)
                                dialogueId++
                            } finally {
                                if (transitionJob ==
                                    currentCoroutineContext()[Job]
                                ) {
                                    isTransitioning = false
                                    transitionJob = null
                                }
                            }
                        }
                    }
                }
            )

            Button(
                enabled = isTransitioning,
                onClick = {
                    transitionJob?.cancel()
                }
            ) {
                Text("Отменить переход")
            }

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
    isTransitioning: Boolean = false,
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
            enabled = !isTransitioning,
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