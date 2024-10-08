package com.hrd.wehr_project.ui.screen.welcome

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hrd.wehr_project.R
import com.hrd.wehr_project.consts.Screen
import kotlinx.coroutines.launch

@SuppressLint("InvalidColorHexValue")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(navController: NavHostController) {
    // Bottom sheet scaffold state
    val scaffoldState = rememberBottomSheetScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    // State to hold the selected language
    var selectedLanguage by remember { mutableStateOf<String?>(null) }
    // Managing bottom sheet for language selection
    BottomSheetScaffold(
        sheetContainerColor = Color.White,
        scaffoldState = scaffoldState,
        sheetContent = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Select Language",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Text(text = "Please select a display language")
                Spacer(modifier = Modifier.height(16.dp))

                // Language Buttons
                LanguageButton(
                    language = "Khmer",
                    imageResId = R.drawable.khmer_flag,
                    isSelected = selectedLanguage == "Khmer",
                    onClick = { selectedLanguage = "Khmer" }
                )
                LanguageButton(
                    language = "Korean",
                    imageResId = R.drawable.korean_flag,
                    isSelected = selectedLanguage == "Korean",
                    onClick = { selectedLanguage = "Korean" }
                )
                LanguageButton(
                    language = "English",
                    imageResId = R.drawable.english_flag,
                    isSelected = selectedLanguage == "English",
                    onClick = { selectedLanguage = "English" }
                )
                Button(
                    onClick = {
                        navController.navigate(Screen.Login.route)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF3F61E9)
                    )
                ) {
                    Text(
                        text = "Select", fontWeight = FontWeight.Bold, fontSize = 15.sp
                    )
                }
            }
        }, sheetPeekHeight = 0.dp, // Hidden by default
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
    ) {
        // Main content above the bottom sheet
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.ceo),
                contentDescription = "CEO Welcome Screen",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
            // Main button to expand the language selector
            Button(
                onClick = {
                    coroutineScope.launch {
                        scaffoldState.bottomSheetState.expand()  // Show bottom sheet

                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 40.dp, vertical = 20.dp),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF3F61E9)
                )
            ) {
                Text(
                    text = "Get Started", fontWeight = FontWeight.Bold, fontSize = 15.sp
                )
            }
        }
    }
}

@SuppressLint("InvalidColorHexValue")
@Composable
fun LanguageButton(language: String, imageResId: Int, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) {
        Color(0xFFFEEF6FF) // Background color when selected
    } else {
        Color(0xFFFFFFF)
    }

    // Reusable button for language selection
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically, // Center the items vertically
            horizontalArrangement = Arrangement.SpaceBetween, // Align items to the start
            modifier = Modifier.fillMaxWidth() // Ensure the Row fills the width
        ) {
            // Display the image on the left
            Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "$language Flag",
                    modifier = Modifier.size(50.dp) // Set the size of the image
                )
                // Display the language text
                Text(
                    text = language, fontSize = 14.sp, fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp),
                    color = Color(0xFFF374957)
                )
            }
            // Display the confirmation image if this language is selected
            if (isSelected) {
                Image(
                    painter = painterResource(id = R.drawable.correctsign), // Your confirmation image
                    contentDescription = "Confirmation",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}



