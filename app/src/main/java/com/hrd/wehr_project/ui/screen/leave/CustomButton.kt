package com.hrd.wehr_project.ui.screen.leave

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color = Color.Blue,
    contentColor: Color = Color.White,
    modifier: Modifier=Modifier
) {
    Box(
        modifier = modifier
           // .fillMaxWidth()
            .heightIn(50.dp) .background(color = backgroundColor, shape = RoundedCornerShape(10.dp))
            .clickable(onClick = onClick)
           ,
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, color = contentColor, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
    }
}