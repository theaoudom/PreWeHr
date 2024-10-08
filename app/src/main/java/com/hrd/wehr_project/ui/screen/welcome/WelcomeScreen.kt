package com.hrd.wehr_project.ui.screen.welcome

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hrd.wehr_project.R
@SuppressLint("InvalidColorHexValue")
@Composable
fun WelcomeScreen() {
    Box(modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.ceo),
            contentDescription = "CEO Welcome Screen ",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomCenter)
                .padding(40.dp, 0.dp, 40.dp, 20.dp),
            shape = RoundedCornerShape(5.dp),  // Set rounded corners here
            colors = ButtonDefaults.buttonColors(
                Color(0xFFF3F61E9)
            )
        ) {
            Text(text = "Get Stated ", fontWeight = FontWeight.Bold, fontSize = 15.sp)
        }
    }

}