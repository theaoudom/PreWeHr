package com.hrd.wehr_project.ui.screen.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hrd.wehr_project.consts.Screen

@Composable
//@Preview(showBackground = true)
fun SignUpScreen(navController : NavHostController){

    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 31.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f)
                .background(Color.White)
                .padding(top = 95.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Sign up",
                fontSize = 16.sp,
                fontWeight = FontWeight.W800
            )
            Text(
                text = "Create an account to get started",
                fontSize = 12.sp,
                fontWeight = FontWeight.W400,
                color = Color(0xFF71727A),
                modifier = Modifier
                    .padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Email Address",
                color = Color(0xff2F3036),
                fontSize = 12.sp,
                fontWeight = FontWeight.W700
            )
            // Input Email Address
            // TODO : Add error handling for invalid inputs
            OutlinedTextField(
                value = email, onValueChange = {email = it},
                placeholder = {
                    Text(text = "name@email.com")
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE5E7EB),
                        shape = RoundedCornerShape(10.dp)
                    )
            )
            Spacer(modifier = Modifier.height(20.dp))
            // Sign up Button
            Button(
                onClick = {
                    navController.navigate(Screen.ConfirmOTP.route)
                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3F61E9)
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Send OTP Code",
                    fontWeight = FontWeight.W700,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                )
            }
        }
    }
}
