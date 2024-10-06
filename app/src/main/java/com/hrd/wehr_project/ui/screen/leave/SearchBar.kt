package com.hrd.wehr_project.ui.screen.leave

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit
) {
    val searchQuery = remember { mutableStateOf(TextFieldValue()) }

    OutlinedTextField(
        value = searchQuery.value,
        onValueChange = {
            searchQuery.value = it
            onSearch(it.text) // Call the search function when input changes
        },
        placeholder = { Text("Search here", fontSize = 16.sp) },
        trailingIcon = {
            Icon(
                Icons.Default.Search, // Replace with your search icon resource
                contentDescription = "Search Icon"
            )
        },
        modifier = modifier
            .width(320.dp)
            .height(60.dp)
            .padding(start = 10.dp, end = 10.dp, top = 10.dp),
//        colors = TextFieldDefaults.textFieldColors(
//           // focusedIndicatorColor = colorResource(id = R.color.search_bg_color), // This won't show in regular TextField
//            unfocusedIndicatorColor = Color.LightGray, // This won't show in regular TextField
//            containerColor = colorResource(id = R.color.search_bg_color)
//        )

        shape = RoundedCornerShape(60.dp),
    )
}