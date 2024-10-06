package com.hrd.wehr_project.ui.screen.leave

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hrd.wehr_project.R

@Composable
fun LeaveScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            //FilterBottomSheet()
            SearchBar(onSearch = { /* Handle search */ })
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 10.dp))
            {
                Icon(
                    painter = painterResource(id = R.drawable.filter_icon),
                    contentDescription = "filter icon",
                    modifier = Modifier.size(24.dp)
                )
                Text(text = "Filter", modifier = Modifier.padding(start = 3.dp))

            }

        }
        Spacer( modifier = Modifier.padding(top = 10.dp))
        Row(verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.Center)
        {

            Text(text = "Select Date : ", modifier = Modifier.padding(start = 10.dp), fontSize = 14.sp, fontWeight = FontWeight.Medium)
            DateRangePicker()
            Row(verticalAlignment = Alignment.CenterVertically)
            {

                Image(
                    painter = painterResource(id = R.drawable.excel),
                    contentDescription = "excel",
                    modifier = Modifier.size(28.dp)
                )
                Text(text = "Download", modifier = Modifier.padding(start = 2.dp, top = 2.dp), fontSize = 13.sp, fontWeight = FontWeight.Medium)

            }
        }




        Text(text = "My Leaves", Modifier.padding(15.dp), fontWeight = FontWeight.Bold, fontSize = 15.sp)
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Allows LazyColumn to expand and be scrollable
        ) {
            item { CardComponent(status = Status.Request) }
            item { CardComponent(status = Status.Approved) }
            item { CardComponent(status = Status.Rejected) }
            item { CardComponent(status = Status.Request) }
            item { CardComponent(status = Status.Approved) }
            item { CardComponent(status = Status.Rejected) }
        }
    }
}