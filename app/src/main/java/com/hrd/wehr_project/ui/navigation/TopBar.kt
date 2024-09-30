package com.hrd.wehr_project.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    TopAppBar(
        title = { /*TODO*/ },
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Person"
            )
        },
        actions = { /*TODO*/ },
    )
}