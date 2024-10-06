package com.hrd.wehr_project.ui.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview(showBackground = true)
fun ConfirmOTPScreen(){

    var otpCode by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 31.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.White)
                .padding(top = 95.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Enter confirmation code",
                fontSize = 16.sp,
                fontWeight = FontWeight.W800,
                color = Color(0xFF1F2024)
            )
            Text(
                text = "A 6-digit code has been sent to",
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                color = Color(0xFF71727A),
                modifier = Modifier
                    .padding(top = 8.dp)
            )
            Text(
                text = "so****7@gmail.com",
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                color = Color(0xFF71727A),
                modifier = Modifier
                    .padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                repeat(6) {
                    OutlinedTextField(
                        value = "", // This would be linked to state holding each digit.
                        onValueChange = { /* Handle digit input */ },
                        modifier = Modifier
                            .width(48.dp)
                            .height(48.dp)
                            .padding(horizontal = 4.dp),
//                        singleLine = true,
                        textStyle = LocalTextStyle.current.copy(
                            textAlign = TextAlign.Center
                        ),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number
                        ),
                        shape = RoundedCornerShape(8.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(bottom = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ){
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Resend Code",
                        color = Color(0xFF006FFD),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.W600
                    )
                }
                // Continue Button
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF3F61E9)
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Text(
                        text = "Continue",
                        fontWeight = FontWeight.W700,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
}
