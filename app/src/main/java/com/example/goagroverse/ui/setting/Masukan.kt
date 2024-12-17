package com.example.goagroverse.ui.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.goagroverse.R

@Composable
fun MasukanScreen(navController: NavController) {
    Box(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Text(
            text = "Berikan Masukan",
            color = Color(0xff303030),
            lineHeight = 4.37.em,
            style = MaterialTheme.typography.headlineLarge,
            modifier = androidx.compose.ui.Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(y = 111.dp)
                .width(272.dp)
                .height(40.dp)
        )
        Text(
            text = "Apakah Kamu Menyukai Aplikasi Kami?",
            color = Color(0xff303030),
            lineHeight = 8.75.em,
            style = TextStyle(fontSize = 16.sp),
            modifier = androidx.compose.ui.Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(y = 158.dp)
                .width(317.dp)
                .height(21.dp)
        )
        Box(
            modifier = androidx.compose.ui.Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 85.dp, y = 203.dp)
                .width(241.dp)
                .height(60.dp)
        ) {
            Box(
                modifier = androidx.compose.ui.Modifier
                    .size(60.dp)
            )
            Box(
                modifier = androidx.compose.ui.Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 91.dp)
                    .size(60.dp)
            )
            Box(
                modifier = androidx.compose.ui.Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 181.dp)
                    .size(60.dp)
            )
        }
        Box(
            modifier = androidx.compose.ui.Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 26.dp, y = 418.dp)
                .width(361.dp)
                .height(247.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(color = Color(0xff78de78).copy(alpha = 0.5f))
        ) {
            Text(
                text = "Isi masukan anda di sini ...",
                color = Color(0xff303030).copy(alpha = 0.5f),
                lineHeight = 11.67.em,
                style = TextStyle(fontSize = 12.sp),
                modifier = androidx.compose.ui.Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 17.dp, y = 16.dp)
                    .width(163.dp)
                    .height(18.dp)
            )
        }
        Text(
            text = "Apakah Anda Memiliki Masukan Terhadap Aplikasi Kami?",
            color = Color(0xff303030),
            lineHeight = 8.75.em,
            style = TextStyle(fontSize = 16.sp),
            modifier = androidx.compose.ui.Modifier
                .align(alignment = Alignment.TopCenter)
                .offset(y = 326.dp)
                .width(317.dp)
                .height(37.dp)
        )
        Box(
            modifier = androidx.compose.ui.Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 26.dp, y = 697.dp)
                .width(361.dp)
                .height(44.dp)
                .clip(shape = RoundedCornerShape(20.dp))
                .background(color = Color(0xff269d26))
        ) {
            Text(
                text = "Kirim Masukan",
                color = Color.White,
                textAlign = TextAlign.Center,
                lineHeight = 7.78.em,
                style = TextStyle(fontSize = 18.sp),
                modifier = androidx.compose.ui.Modifier
                    .align(alignment = Alignment.Center)
                    .width(212.dp)
                    .height(27.dp)
            )
        }
        Box(
            modifier = androidx.compose.ui.Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 22.dp, y = 43.dp)
                .width(115.dp)
                .height(25.dp)
        ) {
            Text(
                text = "Masukan",
                color = Color(0xff303030),
                lineHeight = 7.78.em,
                style = TextStyle(fontSize = 18.sp),
                modifier = androidx.compose.ui.Modifier
                    .align(alignment = Alignment.CenterStart)
                    .offset(x = 15.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.epback),
                contentDescription = "ep:back",
                modifier = androidx.compose.ui.Modifier
                    .align(alignment = Alignment.CenterStart)
                    .size(24.dp)
            )
        }
        Divider(
            color = Color(0xff269d26),
            modifier = androidx.compose.ui.Modifier
                .align(alignment = Alignment.TopStart)
                .offset(y = 292.dp)
                .fillMaxWidth()
                .height(1.dp)
        )
    }
}
