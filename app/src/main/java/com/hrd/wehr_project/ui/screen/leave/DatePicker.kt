package com.hrd.wehr_project.ui.screen.leave

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.DatePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.DatePickerDialog
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.hrd.wehr_project.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DateRangePicker() {
    var startDateMillis by remember { mutableStateOf<Long?>(null) }
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    Column(
        verticalArrangement = Arrangement.spacedBy(2.dp),
       modifier = Modifier.padding(3.dp,15.dp)
    ) {
        // Custom Button to display selected date range
        CustomDateRangeButton(
                       onClick = { showDatePicker = true }
        )

        // Show the DatePickerDialog when the button is clicked
        if (showDatePicker) {
            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(onClick = {
                        startDateMillis = datePickerState.selectedDateMillis
                        showDatePicker = false
                    }) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        showDatePicker = false
                    }) {
                        Text("Dismiss")
                    }
                }
            ) {

                    DatePicker(state = datePickerState)

            }
        }
    }
}

@Composable
fun CustomDateRangeButton( onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(205.dp)
            .height(40.dp).padding(0.dp),
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(1.dp, color = colorResource(id = R.color.button_color)),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
    ) {
        Text(
            text = "Jan 01, 2024 - Feb 01, 2024",
            fontSize = 12.sp,

            color = colorResource(id = R.color.button_color)
        )
    }
}
