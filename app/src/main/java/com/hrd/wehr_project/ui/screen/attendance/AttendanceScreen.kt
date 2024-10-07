package com.hrd.wehr_project.ui.screen.attendance

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hrd.wehr_project.R
import kotlin.text.contains
@Preview
@Composable
fun AttendanceScreen() {

    var searchText by remember { mutableStateOf("") }
    val filteredAttendance = attendanceList.filter {
        it.employeeName.employeeName.contains(searchText, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        SearchFilterBar(searchText) {
            searchText = it
        }
        AttendanceList(filteredAttendance)
    }
}


data class Employee(
    val employeeId: Int,
    val employeeName: String,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchFilterBar(searchText: String, onSearchTextChanged: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedTextField(
            modifier = Modifier,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Gray.copy(0.5f),
                focusedBorderColor = Color.Gray.copy(0.5f),
                containerColor = Color(0xFFF3F8FF)
            ),
            value = searchText,
            onValueChange = { onSearchTextChanged(it) },
            placeholder = { Text("Search hare", color = Color.Gray, fontSize = 12.sp) },
            shape = RoundedCornerShape(20.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    modifier = Modifier
                )
            }
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.filter_alt_24dp_5f6368_fill0_wght400_grad0_opsz24),
                contentDescription = "check out",
            )
            Text(text = "Filter", modifier = Modifier.padding(start = 10.dp))
        }
    }
}

@Composable
fun AttendanceList(attendanceList: List<Attendance>) {
    LazyColumn(
    ) {
        items(attendanceList) { attendance ->
            Card(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .border(0.50.dp, Color.Gray.copy(0.50f), RoundedCornerShape(10.dp)),
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            if (attendance.checkOut.statusName == "Miss Check-out") Color.Red else Color(
                                0xFFFFA500
                            )
                        )
                        .padding(start = 14.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // left check out
                        Column {
                            Text("Leng Socheat")
                            Row {
                                Image(painter = painterResource(R.drawable.output_circle_24dp_2489ff_fill0_wght400_grad0_opsz24), contentDescription = "check out")
                                Column {
                                    Text("Late Check-out")
                                    Text("06:06:43 PM")
                                }
                            }
                        }
                        Column {
                            Text("Leng Sambath")
                        }


                        // Left Date Card
//                        Column(
//                            modifier = Modifier.weight(1f),
//                            verticalArrangement = Arrangement.spacedBy(8.dp)
//                        ) {
//                            Text(
//                                text = attendance.aesDate,
//                                fontSize = 14.sp,
//                                fontWeight = FontWeight.Bold
//                            )
//                            Box{
//                                Row(
//                                    modifier = Modifier.fillMaxWidth(),
//                                    verticalAlignment = Alignment.CenterVertically,
//                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
//                                ) {
//                                    Box(
//                                        modifier = Modifier
//                                            .background(
//                                                Color(0xFF2489FF).copy(0.16f), RoundedCornerShape(5.dp)
//                                            )
//                                            .padding(5.dp)
//                                    ) {
//                                        Image(
//                                            painter = painterResource(R.drawable.output_circle_24dp_2489ff_fill0_wght400_grad0_opsz24),
//                                            contentDescription = "check out",
//                                            Modifier.rotate(270f)
//                                        )
//                                    }
//                                    Column(
//                                        modifier = Modifier,
//                                        verticalArrangement = Arrangement.SpaceBetween
//                                    ) {
//                                        Text(
//                                            text = "06:06:43 PM",
//                                            fontSize = 12.sp,
//                                            modifier = Modifier.padding(bottom = 10.dp)
//                                        )
//                                        if (attendance.checkOut.statusName == "Miss Check-out") {
//                                            Text(
//                                                text = "Miss Check-out",
//                                                color = Color.Red,
//                                                fontSize = 10.sp
//                                            )
//                                        } else {
//                                            Text(
//                                                text = attendance.checkOut.statusName,
//                                                color = Color(0xFFFFA500),
//                                                fontSize = 10.sp
//                                            )
//                                        }
//                                    }
//                                }
//                            }
//                        }

                        // Right Date Card
//                        Column(
//                            modifier = Modifier.weight(0.6f),
//                            verticalArrangement = Arrangement.spacedBy(10.dp)
//                        ) {
//                            Text(
//                                text = attendance.aesDate,
//                                fontSize = 14.sp,
//                                fontWeight = FontWeight.Bold
//                            )
//                            Box{
//                                Row(
//                                    modifier = Modifier.fillMaxWidth(),
//                                    verticalAlignment = Alignment.CenterVertically,
//                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
//                                ) {
//                                    Box(
//                                        modifier = Modifier
//                                            .background(
//                                                Color(0xFF2489FF).copy(0.16f), RoundedCornerShape(5.dp)
//                                            )
//                                            .padding(5.dp)
//                                    ) {
//                                        Image(
//                                            painter = painterResource(R.drawable.output_circle_24dp_2489ff_fill0_wght400_grad0_opsz24),
//                                            contentDescription = "check out",
//                                            Modifier.rotate(90f)
//                                        )
//                                    }
//                                    Column(
//                                        modifier = Modifier,
//                                        verticalArrangement = Arrangement.SpaceBetween
//                                    ) {
//                                        Text(
//                                            text = "06:06:43 PM",
//                                            fontSize = 12.sp,
//                                            modifier = Modifier.padding(bottom = 10.dp)
//                                        )
//                                        if (attendance.checkIn.statusName == "Miss Check-in") {
//                                            Text(
//                                                text = "Miss Check-in",
//                                                color = Color.Red,
//                                                fontSize = 10.sp
//                                            )
//                                        } else {
//                                            Text(
//                                                text = attendance.checkIn.statusName,
//                                                color = Color(0xFFFFA500),
//                                                fontSize = 10.sp
//                                            )
//                                        }
//                                    }
//                                }
//                            }
//                        }
                    }
                }
            }
        }
    }
}

data class Attendance(
    val aesDate: String,
    val desDate: String,
    val employeeName: Employee,
    val checkIn: Status,
    val checkOut: Status,
)

data class Status(
    val statusId: Int,
    val statusName: String,
)

val attendanceList = listOf(
    Attendance(
        aesDate = "2023-11-27",
        desDate = "2023-11-27",
        employeeName = Employee(1, "Sambath"),
        checkIn = Status(1, "Early Check-in"),
        checkOut = Status(2, "Late Check-out")
    ), Attendance(
        aesDate = "2023-11-27",
        desDate = "2023-11-27",
        employeeName = Employee(2, "Outdom"),
        checkIn = Status(3, "Early Check-in"),
        checkOut = Status(2, "Miss Check-out")
    ), Attendance(
        aesDate = "2023-11-27",
        desDate = "2023-11-27",
        employeeName = Employee(3, "Yeang"),
        checkIn = Status(1, "Miss Check-in"),
        checkOut = Status(4, "Late Check-out")
    ), Attendance(
        aesDate = "2023-11-27",
        desDate = "2023-11-27",
        employeeName = Employee(4, "Bob"),
        checkIn = Status(1, "Late Check-in"),
        checkOut = Status(5, "Late Check-out")
    ), Attendance(
        aesDate = "2023-11-27",
        desDate = "2023-11-27",
        employeeName = Employee(5, "Ploy"),
        checkIn = Status(1, "Late Check-in"),
        checkOut = Status(4, "Miss Check-out")
    ), Attendance(
        aesDate = "2023-11-27",
        desDate = "2023-11-27",
        employeeName = Employee(5, "Ploy"),
        checkIn = Status(1, "Miss Check-in"),
        checkOut = Status(4, "Late Check-out")
    ), Attendance(
        aesDate = "2023-11-27",
        desDate = "2023-11-27",
        employeeName = Employee(5, "Ploy"),
        checkIn = Status(1, "Miss Check-in"),
        checkOut = Status(4, "Late Check-out")
    ), Attendance(
        aesDate = "2023-11-27",
        desDate = "2023-11-27",
        employeeName = Employee(5, "Ploy"),
        checkIn = Status(1, "Miss Check-in"),
        checkOut = Status(4, "Late Check-out")
    ), Attendance(
        aesDate = "2023-11-27",
        desDate = "2023-11-27",
        employeeName = Employee(5, "Ploy"),
        checkIn = Status(1, "Miss Check-in"),
        checkOut = Status(4, "Late Check-out")
    )
)