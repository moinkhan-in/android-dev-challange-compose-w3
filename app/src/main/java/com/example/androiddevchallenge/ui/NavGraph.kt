/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.screens.LoginScreen
import com.example.androiddevchallenge.ui.screens.WelcomeScreen
import com.example.androiddevchallenge.ui.screens.home.HomeScreen

/**
 * Destinations used in the ([MySmooth]).
 */
object MainDestinations {
    const val SCREEN_WELCOME = "welcome"
    const val SCREEN_LOGIN = "login"
    const val SCREEN_HOME = "home"
}

@Composable
fun NavGraph(startDestination: String = MainDestinations.SCREEN_WELCOME) {
    val navController = rememberNavController()

    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(MainDestinations.SCREEN_WELCOME) { WelcomeScreen(onButtonClicked = { actions.navigateToSignLogin() }) }
        composable(MainDestinations.SCREEN_LOGIN) { LoginScreen(onLoginSuccess = { actions.navigateToHome() }) }
        composable(MainDestinations.SCREEN_HOME) { HomeScreen() }
    }
}

class MainActions(private val navController: NavHostController) {

    fun navigateToSignLogin() {
        navController.navigate(MainDestinations.SCREEN_LOGIN)
    }

    fun navigateToHome() {
        navController.navigate(MainDestinations.SCREEN_HOME)
    }

    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
