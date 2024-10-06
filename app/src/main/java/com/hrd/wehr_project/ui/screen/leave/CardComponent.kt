package com.hrd.wehr_project.ui.screen.leave

import android.content.res.Resources
import android.graphics.drawable.Icon
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
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hrd.wehr_project.R

//@Preview(showBackground = true)
@Composable
fun CardComponent(status:Status) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding( 15.dp, 5.dp)
            .background(colorResource(id = R.color.white))
            .border(
                border = BorderStroke(width = 1.dp, color = colorResource(id = R.color.border_color)),
                shape = RoundedCornerShape(10.dp)
            )
    )
    {
        Column(Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Annual Leave", color = colorResource(id = R.color.annul_leave_color), fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.weight(1f))
                StatusFilterChip(status )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy((10.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // icon calendar
                Icon(
                    painter = painterResource(id = R.drawable.calendar),
                    contentDescription = "calendar icon",
                    Modifier.size(13.dp)
                )
                // date
                Text("28-07-2024 ", fontWeight = FontWeight.Medium, fontSize = 13.sp)
                // circle
                Icon(
                    painter = painterResource(id = R.drawable.ellipse),
                    contentDescription = "calendar icon",
                    Modifier.size(6.dp),
                    tint = colorResource(
                        id = R.color.circle_color
                    )
                )

                // Duration
                Text("0.5 day off ", fontWeight = FontWeight.Medium, fontSize = 13.sp)
            }
            Row(Modifier.padding(top = 10.dp),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                // icon edit
                Icon(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = "edit icon",
                    Modifier.size(13.dp)
                )
                // reason
                Text("Personal issue", fontWeight = FontWeight.Normal, fontSize = 12.sp)

                Spacer(modifier = Modifier.weight(1f))


                Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "ArrowRight icon")
            }
        }
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



