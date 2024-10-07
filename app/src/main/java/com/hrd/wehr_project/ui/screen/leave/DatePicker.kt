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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.hrd.wehr_project.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateRangePicker() {
    var startDateMillis by remember { mutableStateOf<Long?>(null) }
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    Column(
        verticalArrangement = Arrangement.spacedBy(2.dp),
        // modifier = modifier
    ) {
        // Custom Button to display selected date range
        CustomDateRangeButton(

            onClick = { showDatePicker = true },
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
fun CustomDateRangeButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
        ,     shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, color = colorResource(id = R.color.button_color)),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
    ) {
        Text(
            text = "Jan 01, 2024 - Feb 01, 2024",
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(15.dp,0.dp),

            color = colorResource(id = R.color.button_color)
        )
    }
}
