package com.hrd.wehr_project.ui.screen.leave

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hrd.wehr_project.R
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
            onSearch(it.text)
        },
        placeholder = {
            Text(
                "Search here",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
               color = colorResource(id = R.color.search_text_color) // Ensure the placeholder is visible
            )
        },
        trailingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        modifier = Modifier
            .height(50.dp) // Set fixed height
        , colors = TextFieldDefaults.colors(
            unfocusedContainerColor = colorResource(id = R.color.search_bg_color),
            focusedIndicatorColor = colorResource(id = R.color.search_border_color),
            focusedContainerColor = colorResource(id = R.color.search_bg_color),
            unfocusedIndicatorColor = colorResource(id = R.color.search_border_color)
        ),
        shape = RoundedCornerShape(15.dp),
    )
}