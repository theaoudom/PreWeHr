package com.hrd.wehr_project.ui.screen.auth

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import com.hrd.wehr_project.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.hrd.wehr_project.consts.Screen

@Composable
//@Preview(showBackground = true)
fun LoginScreen(
    navController:NavController
){

    var passwordVisible by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isValid by remember { mutableStateOf(false) }

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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.kosign_logo),
                contentDescription = "logo"
            )
            // Welcome Text
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black
                        )
                    ){
                        append("Welcome to")

                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Blue
                        )
                    ){
                        append(" My HR")
                    }
                },
                fontSize = 26.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Please enter your account here",
                color = Color(0xff6B7280),
                fontSize = 12.sp
            )
            // Input Email Address
            // TODO : Add error handling for invalid inputs
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    isValid = it.trim().split("\\s+".toRegex())
                        .size > 8 && it.isNotBlank()
                                },
                placeholder = {
                    Text(text = "Enter your email")
                },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.email_icon),
                        contentDescription ="",
                        modifier = Modifier
                            .size(24.dp)
                    )
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE5E7EB),
                        shape = RoundedCornerShape(10.dp)
                    )
            )
            Spacer(modifier = Modifier.height(20.dp))
            // Input Password
            // TODO : Add error handling for invalid inputs
            OutlinedTextField(
                value = password, onValueChange = {password = it},
                placeholder = {
                    Text(text = "Enter your password")
                },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.password_icon),
                        contentDescription ="",
                        modifier = Modifier
                            .size(24.dp)
                    )
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE5E7EB),
                        shape = RoundedCornerShape(10.dp)
                    ),
                trailingIcon = {
                    Image(
                        painter = painterResource(id = if(passwordVisible) R.drawable.eye_show_icon else R.drawable.eye_hide_icon),
                        contentDescription ="",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                passwordVisible = !passwordVisible
                            }
                    )
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ){
                Text(
                    text = "Forgot Password?",
                    color = Color.Blue,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier
                        .clickable {
                            /* TODO : Click to Screen Forgot Password */
                        }
                )
            }
            Spacer(modifier = Modifier.height(46.dp))
            // Login Button
            Button(
                onClick = {
                    navController.navigate(Screen.Main.route)
                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3F61E9)
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "Login",
                    fontWeight = FontWeight.W700,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(Color(0xFF6B7280))
                )
                Text(
                    text = "OR SIGN IN WITH",
                    modifier = Modifier
                        .padding(horizontal = 8.dp),
                    color = Color(0xFF6B7280)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(1.dp)
                        .background(Color(0xFF6B7280))
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
            ) {
                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google_image),
                        contentDescription = "",
                        modifier = Modifier.size(40.dp)
                            .shadow(
                                elevation = 2.dp, // Approximate elevation based on blur radius
                                shape = RoundedCornerShape(0.dp), // No rounded corners
                                spotColor = Color(0x00000040) // Shadow color with alpha
                            )
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
//                .background(Color.Red)
                .padding(bottom = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Row {
                Text(
                    text = "Don't have an account? ",
                    color = Color(0xFF6B7280)
                )
                Text(
                    text = "Sign up now",
                    color = Color(0xFF3F61E9),
                    fontWeight = FontWeight.SemiBold,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                        .clickable {
                            val currentRoute = navController.currentBackStackEntry?.destination?.route
                            Log.d("Routeeee", "Current Route: $currentRoute")
                           // Check if navController is not null before navigating
                            if (currentRoute != null) {
                                navController.navigate(Screen.SignUp.route)
                            } else {
                                Log.e("Routeeee", "Navigation failed: current route is null")
                            }
                        }
                )
            }
        }
    }
}