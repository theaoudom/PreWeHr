package com.hrd.wehr_project.ui.screen.leave

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hrd.wehr_project.R
import com.hrd.wehr_project.consts.ScreenLeave

@Composable
fun CardComponent(leaveData: LeaveData,navHostController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp, 5.dp)
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = colorResource(id = R.color.border_color)
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .background(colorResource(id = R.color.white), shape = RoundedCornerShape(10.dp))
            .clickable { navHostController.navigate(ScreenLeave.ScreenRequestLeaveRoute.route) }
        
    )
    {
        Column(Modifier.padding(10.dp,8.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = leaveData.leaveType, color =  getLeaveTypeColor(leaveData.leaveType), fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.weight(1f))
                StatusFilterChip(leaveData.status)
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy((10.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // icon calendar
                Icon(
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = "calendar icon",
                    Modifier.size(14.dp)
                )
                // date
                Text(leaveData.leaveDate, fontWeight = FontWeight.Medium, fontSize = 13.sp)
                // circle
                Icon(
                    painter = painterResource(id = R.drawable.ellipse),
                    contentDescription = "calendar icon",
                    Modifier.size(7.dp),
                    tint = colorResource(
                        id = R.color.circle_color
                    )
                )

                // Duration
                Text(leaveData.duration, fontWeight = FontWeight.Medium, fontSize = 13.sp)
            }
            Row(Modifier.padding(top = 10.dp),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                // icon edit
                Icon(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = "edit icon",
                    Modifier.size(13.dp)
                )
                // reason
                Text(leaveData.reason, fontWeight = FontWeight.Normal, fontSize = 12.sp)

                Spacer(modifier = Modifier.weight(1f))


                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "ArrowRight icon", tint = colorResource(
                    id = R.color.text_color
                ))
            }
        }
    }
}



data class LeaveData(
    val status: Status,
    val leaveType: String,
    val leaveDate: String,
    val duration: String,
    val reason: String
)

@Composable
fun getLeaveTypeColor(leaveType: String): Color {
    return when (leaveType) {
        LeaveType.SickLeave -> colorResource(id = R.color.sick_leave_color)
        LeaveType.SpecialLeave -> colorResource(id = R.color.special_leave_color)
        LeaveType.AnnualLeave -> colorResource(id = R.color.annul_leave_color)
        else -> Color.Black // Default color if none match
    }
}







@Composable
fun StatusFilterChip(status: Status, enabled: Boolean = false) {
    val (label, colors) = when (status) {
        Status.Request -> Pair("Request", FilterChipDefaults.filterChipColors(
            disabledLabelColor = colorResource(id = R.color.request_text_color),
            disabledSelectedContainerColor = colorResource(id = R.color.request_bg_color)
        ))
        Status.Rejected -> Pair("Rejected", FilterChipDefaults.filterChipColors(
           disabledLabelColor = colorResource(id = R.color.rejected_color),
            disabledSelectedContainerColor = colorResource(id = R.color.rejected_bg_color)
        ))
        Status.Approved -> Pair("Approved", FilterChipDefaults.filterChipColors(
            disabledLabelColor = colorResource(id = R.color.approve_color),
            disabledSelectedContainerColor = colorResource(id = R.color.approve_bg_color)
        ))
    }

    FilterChip(
        selected = true, // Update this according to your selection logic
        onClick = {},
        enabled = enabled,
        label = { Text(label, fontWeight = FontWeight.Medium) },
        colors = colors,

        modifier = Modifier.padding(PaddingValues(4.dp)) // Optional padding
    )
}



