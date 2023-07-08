package com.danielys.myapplication.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danielys.myapplication.R
import com.danielys.myapplication.ui.theme.CarTheme

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    ProfileContent(modifier)
}

@Composable
fun ProfileContent(modifier: Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.profile) , contentDescription = null,
            Modifier
                .clip(
                    CircleShape
                )
                .width(200.dp))
        Spacer(modifier = modifier.height(20.dp))
        Text(text = "Daniel Yulius Soetjipto", fontWeight = FontWeight.Bold, fontSize = 25.sp)
        Spacer(modifier = modifier.height(5.dp))
        Text(text = "danielyuliussoetjipto@gmail.com")
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailContentPreview() {
    CarTheme() {
        ProfileContent()
    }
}