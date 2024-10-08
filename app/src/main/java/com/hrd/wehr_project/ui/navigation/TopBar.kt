package com.hrd.wehr_project.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hrd.wehr_project.R
import com.hrd.wehr_project.consts.AllOvertimeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavHostController){
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "profile_user",
                    modifier = Modifier.clip(CircleShape).size(40.dp),
                    contentScale = ContentScale.Crop
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.add),
                    contentDescription = "add",
                    modifier = Modifier.size(28.dp),
                    tint = Color.Black
                )
            }
            IconButton(onClick = {navController.navigate(AllOvertimeScreen.OvertimeDetailScreen.route)}) {
                Icon(
                    painter = painterResource(R.drawable.bell),
                    contentDescription = "notification",
                    modifier = Modifier.size(28.dp),
                    tint = Color.Black
                )
            }
        }
    )
}