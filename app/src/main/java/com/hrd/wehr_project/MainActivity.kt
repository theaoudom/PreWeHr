package com.hrd.wehr_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.hrd.wehr_project.ui.navigation.AppNavigation
import com.hrd.wehr_project.ui.screen.welcome.WelcomeScreen
import com.hrd.wehr_project.ui.theme.WeHr_ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val isAuthenticated by remember { mutableStateOf(false) }
            AppNavigation(navController = navController, isAuthenticated = isAuthenticated)

//            WeHr_ProjectTheme {
//
//            }
        }
    }
}