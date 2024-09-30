package com.hrd.wehr_project.ui.screen.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.hrd.wehr_project.ui.navigation.BottomNavigationBar
import com.hrd.wehr_project.ui.navigation.NavigationHost
import com.hrd.wehr_project.ui.navigation.TopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavHostController){
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        topBar = {
            TopBar()
        }
    ) {
        Column (
            modifier = Modifier.padding(it)
        ){
            NavigationHost(navController = navController)
        }
    }
}