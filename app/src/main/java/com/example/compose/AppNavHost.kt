package com.example.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = First,
        modifier = modifier
    ) {
        composable<First> {
            FirstScreen(
                onClickButton = {
                    navController.navigate(Second)
                }
            )

        }
        composable<Second> {
            SecondScreen(
                onClickButton = {
                    navController.popBackStack()
                }
            )

        }
    }
}