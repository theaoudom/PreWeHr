package com.hrd.wehr_project.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hrd.wehr_project.consts.Screen
import com.hrd.wehr_project.ui.screen.auth.ConfirmOTPScreen
import com.hrd.wehr_project.ui.screen.auth.LoginScreen
import com.hrd.wehr_project.ui.screen.auth.SignUpScreen
import com.hrd.wehr_project.ui.screen.main.MainScreen
import com.hrd.wehr_project.ui.screen.welcome.WelcomeScreen

@Composable
fun AppNavigation(navController: NavHostController, isAuthenticated: Boolean) {
    NavHost(navController = navController, startDestination = if (isAuthenticated) Screen.Main.route else Screen.Welcome.route) {
        // Authentication Screens
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.SignUp.route) { SignUpScreen(navController) }
        composable(Screen.ConfirmOTP.route) { ConfirmOTPScreen() }
        composable(Screen.Welcome.route){ WelcomeScreen()}

        // Main Screens
        composable(Screen.Main.route) { MainScreen() }
    }
}