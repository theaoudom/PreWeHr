package com.hrd.wehr_project.ui.screen.component

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.hrd.wehr_project.R
@Composable
fun DeleteDialog(
    onConfirm: () -> Unit,
    onCancel: () -> Unit,
    isDialogOpen: Boolean
) {
    if (isDialogOpen) {
        AlertDialog(
            onDismissRequest = onCancel,
            title = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(vertical = 16.dp)
                ) {
                    // Delete Icon inside a circular red background
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(64.dp)
                            .background(
                                color = colorResource(R.color.delete_color), // Red background
                                shape = CircleShape
                            )
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.trash), // Delete icon
                            contentDescription = "delete icon",
                            tint = colorResource(R.color.star_color), // White icon color
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Text asking for confirmation
                    Text(
                        text = "Are you sure to delete?",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W600,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            },

            // Confirm and Cancel buttons placed in a Row inside the confirmButton
            confirmButton = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween // Space between buttons
                ) {
                    // Cancel Button
                    Button(
                        onClick = onCancel,
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.cancel_color)),
                        shape = RoundedCornerShape(10.dp), // Rounded button corners
                        modifier = Modifier.weight(1f) // Make the button fill space evenly
                    ) {
                        Text(text = "Cancel", color = Color(0xFF757575),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W500
                            )
                    }

                    Spacer(modifier = Modifier.width(16.dp)) // Add space between buttons

                    // Confirm Button
                    Button(
                        onClick = onConfirm,
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.star_color)),
                        shape = RoundedCornerShape(10.dp), // Rounded button corners
                        modifier = Modifier.weight(1f) // Make the button fill space evenly
                    ) {
                        Text(text = "Confirm", color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W500
                            )
                    }
                }
            },
            shape = RoundedCornerShape(35.dp), // Rounded corners for the dialog
            modifier = Modifier.padding(16.dp),
            containerColor = colorResource(R.color.background_dialog)
        )
    }
}


//