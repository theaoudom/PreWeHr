package com.hrd.wehr_project.ui.screen.leave


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hrd.wehr_project.R

@SuppressLint("Range")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeaveScreen() {
    var data = listOf(
        LeaveData(
            status = Status.Request,
            leaveType = LeaveType.SickLeave,
            leaveDate = "15-10-2024",
            duration = "1 day off",
            reason = "Illness"
        ), LeaveData(
            status = Status.Approved,
            leaveType = LeaveType.AnnualLeave,
            leaveDate = "25-10-2024",
            duration = "2 days off",
            reason = "Family trip"
        ), LeaveData(
            status = Status.Request,
            leaveType = LeaveType.SpecialLeave,
            leaveDate = "01-11-2024",
            duration = "0.5 day off",
            reason = "Personal matter"
        ), LeaveData(
            status = Status.Rejected,
            leaveType =LeaveType.AnnualLeave,
            leaveDate = "01-11-2024",
            duration = "0.5 day off",
            reason = "Personal matter"
        ),
        LeaveData(
            status = Status.Approved,
            leaveType = LeaveType.SpecialLeave,
            leaveDate = "01-11-2024",
            duration = "0.5 day off",
            reason = "Personal matter"
        )
    )
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(15.dp)
                //modifier = Modifier.padding(top = 10.dp)

            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.filter_icon),
                    contentDescription = "filter icon",
                    modifier = Modifier.size(24.dp)
                )
                Text(text = "Filter", fontWeight = FontWeight.Medium, fontSize = 16.sp)//, modifier = Modifier.padding(start = 3.dp)

            }
            Spacer(modifier = Modifier.padding(start = 20.dp))
            SearchBar(onSearch = { /* Handle search */ })




        }
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
            , modifier = Modifier.fillMaxWidth()
        )
        {

            Text(
                text = "Select Date : ",
                modifier = Modifier.weight(1f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
            DateRangePicker()

        }




        Text(
            text = "My Leaves",
            Modifier.padding(top = 15.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(data.size)
            {
                CardComponent(leaveData=data[it])
            }

        }
    }
}
