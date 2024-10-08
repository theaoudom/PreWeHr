package com.hrd.wehr_project.ui.screen.component

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hrd.wehr_project.R

data class OvertimeData(
    val overtimeType: String,
    val date: String,
    val totalHour: String
)

val listOfOvertimeData = listOf(
    OvertimeData(
        overtimeType = "Request",
        date = "04-02-2024",
        totalHour = "1.38 hours"
    ),
    OvertimeData(
        overtimeType = "Rejected",
        date = "04-02-2024",
        totalHour = "1.5 hours"
    ),
    OvertimeData(
        overtimeType = "Approved",
        date = "04-02-2024",
        totalHour = "1.38 hours"
    ),
)

@Composable
@Preview(showSystemUi = true)
fun OvertimeCard() {
    Column(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp)
    ) {
        // Loop through the list of overtime data and create a card for each
        listOfOvertimeData.forEach { overtime ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .border(0.2.dp, Color(0xFFF3F4F6), RoundedCornerShape(12.dp)),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(12.dp),
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ) {
                    // Title Row with Overtime Type Badge
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Overtime",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color(0xFF3F61E9)
                        )
                        OvertimeTypeBadge(type = overtime.overtimeType)
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Date and Total Hours Section
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.calendar),
                            contentDescription = "calendar",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = overtime.date,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = overtime.totalHour,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Hours and Task Details
                    Column {
                        // Task Descriptions
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.calendar_line),
                                contentDescription = "calendar_line",
                                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(
                                    text = "- Fix Create Customer",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "- Get data from main",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 8.dp),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.angel),
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun OvertimeTypeBadge(type: String) {
    val backgroundColor: Color
    val textColor: Color

    when (type) {
        "Approved" -> {
            backgroundColor = Color(0xFFCCFBF1) // Green background
            textColor = Color(0xFF0D9488)
        }
        "Rejected" -> {
            backgroundColor = Color(0xFFFEE9E7) // Red background
            textColor = Color(0xFFEC221F)
        }
        else -> {
            backgroundColor = Color(0xFFDFF7FC) // Amber background
            textColor = Color(0xFF2489FF)
        }
    }

    Box(
        modifier = Modifier
            .background(backgroundColor, RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp)

    ) {
        Text(
            text = type,
            color = textColor,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}