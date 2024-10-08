package com.hrd.wehr_project.ui.screen.component

import android.app.DatePickerDialog
import android.inputmethodservice.Keyboard.Row
import android.widget.DatePicker
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hrd.wehr_project.R
import com.hrd.wehr_project.ui.theme.borderColor
import com.maxkeppeker.sheets.core.models.base.rememberUseCaseState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import com.maxkeppeler.sheets.calendar.models.CalendarStyle
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.StringJoiner

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun RequestOvertimeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.angel_left),
                contentDescription = "angel_left",
                modifier = Modifier.size(24.dp)
            )
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Request OT",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    color = Color(0xFF3F61E9),

                    )
            }

        }

        Row {
            Text(text = "Select date",
                fontSize = 16.sp,
                fontWeight = FontWeight.W400
            )

            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "*",
                fontSize = 16.sp,
                color = colorResource(R.color.star_color),
                fontWeight = FontWeight.W400
            )
        }

        OutlinedTextField(
            value = "", // Placeholder for date input
            onValueChange = {},
            modifier = Modifier.fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color(0xFFE5E7EB),
                    shape = RoundedCornerShape(10.dp),

                    ),
            placeholder = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.calendar2),
                        contentDescription = "calendar",
                        modifier = Modifier.size(20.dp)
                    )
                    Text(text = "01 Aug 2024",
                        fontWeight = FontWeight.W400
                        )

                }
            },
            shape = RoundedCornerShape(10.dp)

        )

        Text(text = "Select time",
            fontSize = 16.sp,
            fontWeight = FontWeight.W400
            )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = "", // Placeholder for start time
                onValueChange = {},
                modifier = Modifier.weight(1f)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE5E7EB),
                        shape = RoundedCornerShape(10.dp),

                        ),
                placeholder = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.clock_three),
                            contentDescription = "calendar",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(text = "17:30",
                            fontWeight = FontWeight.W400
                            )

                    }
                },
                shape = RoundedCornerShape(10.dp)

            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "to",
                fontSize = 16.sp,
                fontWeight = FontWeight.W400
                )
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(
                value = "", // Placeholder for end time
                onValueChange = {},
                modifier = Modifier.weight(1f)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE5E7EB),
                        shape = RoundedCornerShape(10.dp),

                        ),
                placeholder = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.clock_three),
                            contentDescription = "calendar",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(text = "20:00",
                            fontWeight = FontWeight.W400
                            )

                    }
                },
                shape = RoundedCornerShape(10.dp)
            )
        }

        Text(text = "Duration",
            fontSize = 16.sp,
            fontWeight = FontWeight.W400
            )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            OutlinedTextField(
                value = "", // Placeholder for duration
                onValueChange = {},
                modifier = Modifier.weight(1f)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE5E7EB),
                        shape = RoundedCornerShape(10.dp),

                    ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = colorResource(R.color.backgroundTextField_RequestOT),
                    ),
                placeholder = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.clock_three),
                            contentDescription = "calendar",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(text = "1.38",
                            fontWeight = FontWeight.W400
                            )

                    }
                },
                shape = RoundedCornerShape(10.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "0.125 for 1h if you work 8h/day",
                fontSize = 13.sp,
                color = colorResource(R.color.smallText),
                fontWeight = FontWeight.W400
            )
        }

        Row {
            Text(text = "Reason",
                fontSize = 16.sp,
                fontWeight = FontWeight.W400
            )
        Spacer(modifier = Modifier.width(4.dp))
            Text(text = "*",
                fontSize = 16.sp,
                color = colorResource(R.color.star_color),
                fontWeight = FontWeight.W400
            )
        }

        OutlinedTextField(
            value = "", // Placeholder for reason
            onValueChange = {},
            placeholder = { Text(text = "Personal issue") },
            modifier = Modifier.fillMaxWidth().height(100.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFE5E7EB),
                    shape = RoundedCornerShape(10.dp),

                    ),
            shape = RoundedCornerShape(10.dp)
        )

        Button(
            onClick = { /* Handle Apply Overtime */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F61E9)),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Apply Overtime", color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.W600
                )
        }
    }
}