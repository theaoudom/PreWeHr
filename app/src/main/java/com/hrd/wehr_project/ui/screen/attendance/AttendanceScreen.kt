package com.hrd.wehr_project.ui.screen.attendance

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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

@Composable
fun SearchFilterBar(searchText: String, onSearchTextChanged: (String) -> Unit) {

}

@Composable
fun AttendanceList(attendanceList: List<Attendance>) {
    Text("List Attendance",
        fontWeight = FontWeight.W700,
        fontSize = 15.sp,
        lineHeight = 17.sp,
        color = Color(0xFF090920),
        modifier = Modifier.padding(bottom = 10.dp)
    )
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
                            if (attendance.checkOut.statusName == "Miss Check-out") Color(0xFFEC221F) else Color(
                                0xFFFF9C01
                            )
                        )
                        .padding(start = 10 .dp),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
//                        // Left Date Card
                        Column(
                        ) {
                            Text(
                                modifier = Modifier.padding(bottom = 10.dp),
                                text = attendance.aesDate,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.W500,
                                lineHeight = 15.sp,
                                color = Color(0xFF090920)
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .background(
                                            Color(0xFF2489FF).copy(0.16f), RoundedCornerShape(5.dp)
                                        )
                                        .padding(5.dp)
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.play_for_work),
                                        contentDescription = "check out",
                                        Modifier.rotate(270f)
                                    )
                                }
                                Column(
                                    modifier = Modifier,
                                    verticalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        color = Color(0xFF090920),
                                        fontWeight = FontWeight.W400,
                                        text = "06:06:43 PM",
                                        lineHeight = 12.sp,
                                        fontSize = 11.sp,
                                        modifier = Modifier.padding(bottom = 10.dp)
                                    )
                                    if (attendance.checkOut.statusName == "Miss Check-out") {
                                        Text(
                                            text = "Miss Check-out",
                                            color = Color(0xFFEC221F),
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.W500
                                        )
                                    } else {
                                        Text(
                                            text = attendance.checkOut.statusName,
                                            color = Color(0xFFFF9C01),
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.W500,
                                            lineHeight = 12.sp
                                        )
                                    }
                                }
                            }
                        }
//
//                        // Right Date Card
                        Column(
                            modifier = Modifier.padding(end = 14.dp)
                        ) {
                            Text(
                                modifier = Modifier.padding(bottom = 10.dp),
                                text = attendance.desDate,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.W500,
                                lineHeight = 15.sp,
                                color = Color(0xFF090920)
                            )
                            Box {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .background(
                                                Color(0xFF2489FF).copy(0.16f),
                                                RoundedCornerShape(5.dp)
                                            )
                                            .padding(5.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(R.drawable.play_for_work),
                                            contentDescription = "check out",
                                            Modifier.rotate(90f)
                                        )
                                    }
                                    Column(
                                        modifier = Modifier,
                                        verticalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            color = Color(0xFF090920),
                                            fontWeight = FontWeight.W400,
                                            text = "06:06:43 PM",
                                            lineHeight = 12.sp,
                                            fontSize = 11.sp,
                                            modifier = Modifier.padding(bottom = 10.dp)
                                        )
                                        if (attendance.checkIn.statusName == "Miss Check-in") {
                                            Text(
                                                text = "Miss Check-in",
                                                color = Color(0xFFEC221F),
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.W500
                                            )
                                        } else {
                                            Text(
                                                text = attendance.checkIn.statusName,
                                                color = Color(0xFFFF9C01),
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.W500,
                                                lineHeight = 12.sp
                                            )
                                        }
                                    }
                                }
                            }
                        }
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