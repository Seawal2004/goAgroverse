package com.example.goagroverse.ui.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.goagroverse.R

@Composable
fun TentangKamiScreen(
    navController: NavController
) {
    Box(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        // Header
        Box(
            modifier = androidx.compose.ui.Modifier
                .align(Alignment.TopStart)
                .offset(x = 20.dp, y = 44.dp)
                .size(width = 159.dp, height = 25.dp)
        ) {
            Text(
                text = "Tentang Kami",
                color = Color(0xff303030),
                lineHeight = 7.78.em,
                style = TextStyle(fontSize = 18.sp),
                modifier = androidx.compose.ui.Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = 15.dp, y = 0.dp)
            )
            Box(
                modifier = androidx.compose.ui.Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 1.dp)
                    .size(24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.epback),
                    contentDescription = "Back Button",
                    modifier = androidx.compose.ui.Modifier.size(24.dp)
                )
            }
        }

        // Footer
        Box(
            modifier = androidx.compose.ui.Modifier
                .align(Alignment.TopStart)
                .offset(x = 1.dp, y = 827.dp)
                .size(width = 412.dp, height = 90.dp)
        ) {
            Box(
                modifier = androidx.compose.ui.Modifier
                    .size(width = 412.dp, height = 90.dp)
                    .background(color = Color(0xff269d26))
            )
            Box(
                modifier = androidx.compose.ui.Modifier
                    .align(Alignment.TopStart)
                    .offset(x = 0.dp, y = 20.4.dp)
                    .size(width = 412.dp, height = 48.dp)
            ) {
                Text(
                    text = "Care Instruction",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 2.em,
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
                    modifier = androidx.compose.ui.Modifier
                        .align(Alignment.CenterStart)
                        .offset(x = 0.dp, y = (-2.4).dp)
                        .size(width = 136.dp, height = 43.dp)
                )
                Text(
                    text = "Terms of Service",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 2.em,
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
                    modifier = androidx.compose.ui.Modifier
                        .align(Alignment.Center)
                        .offset(x = 3.08.dp, y = 0.dp)
                        .size(width = 121.dp, height = 48.dp)
                )
                Text(
                    text = "Privacy Policy",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 2.em,
                    style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
                    modifier = androidx.compose.ui.Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = 0.dp, y = 2.4.dp)
                        .size(width = 132.dp, height = 45.dp)
                )
            }
        }

        // Row for Social Media Logos
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 695.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_ig),
                contentDescription = "Instagram Logo",
                modifier = Modifier.size(40.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.logo_facebook),
                contentDescription = "Facebook Logo",
                modifier = Modifier.size(40.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.logo_x),
                contentDescription = "Twitter Logo",
                modifier = Modifier.size(40.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.logo_threads),
                contentDescription = "LinkedIn Logo",
                modifier = Modifier.size(40.dp)
            )
        }

        // Website Text
        Text(
            textAlign = TextAlign.Center,
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Black, fontSize = 13.sp, fontWeight = FontWeight.Medium)) {
                    append("Kunjungi laman kami di\n ")
                }
                withStyle(style = SpanStyle(color = Color.Black, fontSize = 13.sp, fontWeight = FontWeight.Bold)) {
                    append("www.agroverse.com")
                }
            },
            modifier = androidx.compose.ui.Modifier
                .align(Alignment.TopCenter)
                .offset(x = 0.dp, y = 734.dp)
        )

        // Background Images
        Image(
            painter = painterResource(id = R.drawable.settingbg),
            contentDescription = "Background Image",
            modifier = androidx.compose.ui.Modifier
                .align(Alignment.TopCenter)
                .offset(x = 0.dp, y = 110.dp)
                .size(width = 412.dp, height = 538.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.bunga_kirisan),
            contentDescription = "Overlay Image",
            alpha = 0.4f,
            modifier = androidx.compose.ui.Modifier
                .align(Alignment.TopStart)
                .offset(x = 434.5.dp, y = 130.dp)
                .size(width = 412.dp, height = 538.dp)
        )

        // Content Text
        Box(
            modifier = androidx.compose.ui.Modifier
                .align(Alignment.TopStart)
                .offset(x = 26.dp, y = 156.dp)
                .size(width = 360.dp, height = 441.dp)
        ) {
            Text(
                text = "AgroVerse adalah platform digital yang bertujuan untuk mengedukasi dan memberi akses pasar tanaman hias di Indonesia. AgroVerse ingin menciptakan ekosistem yang mendukung para pencinta tanaman dan petani lokal, di mana siapa pun dapat belajar, tumbuh, dan menemukan solusi tanaman hias terbaik.",
                color = Color.White,
                textAlign = TextAlign.Center,
                lineHeight = 9.38.em,
                style = TextStyle(fontSize = 16.sp),
                modifier = androidx.compose.ui.Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = 0.dp, y = 48.dp)
                    .size(width = 360.dp, height = 393.dp)
            )
            Text(
                text = "Tentang Kami",
                color = Color.White,
                textAlign = TextAlign.Center,
                lineHeight = 7.5.em,
                style = TextStyle(
                    fontSize = 20.sp,
                    shadow = Shadow(color = Color.Black.copy(alpha = 0.3f), offset = Offset(0f, 4f), blurRadius = 4f)
                ),
                modifier = androidx.compose.ui.Modifier
                    .align(Alignment.TopCenter)
                    .offset(x = (-0.5).dp, y = 0.dp)
                    .size(width = 253.dp, height = 30.dp)
            )
        }
    }
}
