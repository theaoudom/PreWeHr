package com.hrd.wehr_project.ui.screen.overtime

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.hrd.wehr_project.R
import com.hrd.wehr_project.ui.screen.component.DeleteDialog

@Preview(showSystemUi = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OvertimeDetailScreen(){
    var isExpanded by remember { mutableStateOf(false) }
    var isDialogOpen by remember { mutableStateOf(false) }
//@Composable
//fun MyApp() {
//    var isDialogOpen by remember { mutableStateOf(true) }
//
//    // Call the dialog and pass the actions for Confirm and Cancel buttons
//    DeleteDialog(
//        onConfirm = {
//            // Handle delete action here
//            isDialogOpen = false
//        },
//        onCancel = {
//            isDialogOpen = false
//        },
//        isDialogOpen = isDialogOpen
//    )
//}
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(R.drawable.angel_left),
                contentDescription = "angel_left",
                modifier = Modifier.size(24.dp)
            )

                Text(
                    text = "Overtime Detail",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    color = Color(0xFF3F61E9),

                    )

             Column {
                 IconButton(onClick = {isExpanded = true}) {
                     Icon(
                         painter = painterResource(R.drawable.group),
                         contentDescription = "group",
                         modifier = Modifier.size(24.dp)
                     )
                 }

                 DropdownMenu(
                     expanded = isExpanded,
                     onDismissRequest = {isExpanded = false},
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFFE6E6E6),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .background(Color.White, shape = RoundedCornerShape(10.dp))
//                        .size(width = 100.dp, height = 80.dp)

                 ) {

                     DropdownMenuItem(
                         text = { Text(text = "Edit",
                            fontSize = 14.sp,
                             fontWeight = FontWeight.W400
                             ) },
                         onClick = {isExpanded = false}, // for edit overtime
                         trailingIcon = {
                             Icon(
                                 painter = painterResource(R.drawable.pencil),
                                 contentDescription = "pencil",
                                 modifier = Modifier.size(16.dp),
                                 tint = colorResource(R.color.pen_color)
                             )
                         }
                     )
                     // delete dropdown section
                     DropdownMenuItem(
                         text = { Text(text = "Delete",
                             fontSize = 14.sp,
                             fontWeight = FontWeight.W400
                         ) },
                         onClick = {
                           isDialogOpen = true
                         }, // for edit overtime
                         trailingIcon = {
                             Icon(
                                 painter = painterResource(R.drawable.trash),
                                 contentDescription = "pencil",
                                 modifier = Modifier.size(16.dp),
                                 tint = colorResource(R.color.delete_color)
                             )
                         }
                     )
                 }
             }


        }

        // Call function delete dialog
        DeleteDialog(
            onConfirm = {},
            onCancel = {},
            isDialogOpen = isDialogOpen
        )


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


    }
}


