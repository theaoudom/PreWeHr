package com.hrd.wehr_project.ui.screen.overtime

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hrd.wehr_project.R
import com.hrd.wehr_project.consts.AllOvertimeScreen
import com.hrd.wehr_project.ui.screen.component.OvertimeCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OvertimeScreen(navController: NavHostController) {
    Scaffold(
        topBar = { OvertimeTopAppBar(navController) }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            item {
                MyOverTime()
            }
            item {
                OvertimeCard()
            }

        }


    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OvertimeTopAppBar(navController: NavHostController) {
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchSection() {
    var searchQuery by remember { mutableStateOf("") }
    val items = listOf("Apple", "Banana", "Cherry", "Date")
    var active by remember { mutableStateOf(false) }
    val filteredItems = items.filter { it.contains(searchQuery, ignoreCase = true) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center, // Center both elements horizontally
        verticalAlignment = Alignment.CenterVertically
    ) {
        // SearchBar with weight to occupy available space
        SearchBar(
            query = searchQuery,
            onQueryChange = { searchQuery = it },
            onSearch = { active = false },
            active = active,
            onActiveChange = { active = it },
            placeholder = { Text(text = "Search") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                )
            },
            modifier = Modifier
                .weight(1f) // Take up available space
                .padding(end = 8.dp) // Space between SearchBar and Filter
        ) {
            // Search Content here
            filteredItems.forEach { item ->
                Text(text = item, fontSize = 15.sp, modifier = Modifier.padding(4.dp))
            }
        }

        // Filter icon and text in a single row
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = "filter",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Filter",
                fontSize = 18.sp, // Adjust font size
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}


@Composable
fun MyOverTime(){
    Row(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.overtime_icon),
            contentDescription = "overtime",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
            text = "My Overtime",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}



