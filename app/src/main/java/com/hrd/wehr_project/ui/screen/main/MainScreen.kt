package com.hrd.wehr_project.ui.screen.main

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.hrd.wehr_project.ui.navigation.BottomNavigationBar
import com.hrd.wehr_project.ui.navigation.NavigationHost
import com.hrd.wehr_project.ui.navigation.TopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    Log.d("Routeeee", "Main Route: $currentRoute")
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        topBar = {
            TopBar(navController = navController)
        }
    ) {
        Column (
            modifier = Modifier.padding(it)
        ){
            NavigationHost(navController = navController)
        }
    }
}