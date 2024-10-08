package com.hrd.wehr_project.ui.screen.leave


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hrd.wehr_project.R

@Composable
fun LeaveUpdate(navController: NavHostController) {
    var dropdownExpanded by remember { mutableStateOf(false) }
    var selectedTime by remember { mutableStateOf("Select Time") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)

    ) {
        // Navigation Row
        Row(
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.Center

        ) {
            IconButton(onClick = { /* Handle navigation back */ }) {
                Icon(Icons.Filled.KeyboardArrowLeft, contentDescription = "ArrowLeft icon",Modifier.size(24.dp))
            }
            Text(text = "Request Leave",Modifier.fillMaxWidth(), fontSize = 20.sp, fontWeight = FontWeight.SemiBold, color = colorResource(
                id = R.color.request_leave_text_color
            ), textAlign = TextAlign.Center )
        }
        // Start date section
        Text(text = "Start date", modifier = Modifier.padding(top = 16.dp))

        Row {
            OutlinedTextField(
                value = "01 Aug 2024",
                onValueChange = { /* Handle date change */ },
                modifier = Modifier.weight(1f)
            )

            OutlinedButton(
                onClick = { dropdownExpanded = true },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = selectedTime) // Display selected time
            }
        }

        // DropdownMenu
        DropdownMenu(
            expanded = dropdownExpanded,
            onDismissRequest = { dropdownExpanded = false },
            modifier = Modifier.width(120.dp)
        ) {
            DropdownMenuItem(onClick = {
                selectedTime = "Morning"
                dropdownExpanded = false // Dismiss the dropdown
            }) {
                Text(text = "Morning")
            }
            DropdownMenuItem(onClick = {
                selectedTime = "Afternoon"
                dropdownExpanded = false // Dismiss the dropdown
            }) {
                Text(text = "Afternoon")
            }
        }

        // Duration section
        Text(text = "Duration", modifier = Modifier.padding(top = 16.dp))
        Row {
            OutlinedTextField(
                value = "1.5 days off",
                onValueChange = { /* Handle duration change */ },
                modifier = Modifier.weight(1f)
            )
        }

        // Reason section
        Text(text = "Reason", modifier = Modifier.padding(top = 16.dp))
        OutlinedTextField(
            value = "Personal issue",
            onValueChange = { /* Handle reason change */ },
            modifier = Modifier.fillMaxWidth()
        )

        // Apply button
       CustomButton(text = "Apply Leave", onClick = { /*TODO*/ })
    }
}