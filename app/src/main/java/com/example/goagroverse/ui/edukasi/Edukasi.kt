package com.example.appagroverse

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.goagroverse.R

@Composable
fun EdukasiScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(modifier = Modifier.padding(16.dp)) {
        // Header Section
        Text(
            text = "Kategori Tanaman Hias",
            fontSize = 16.sp,
            color = Color(0xFF303030)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Jenis Tanaman Hias",
            fontSize = 12.sp,
            color = Color(0xFF303030)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Category Items
        CategoryItem(
            imageRes = R.drawable.hiasbunga,
            title = "Tanaman Hias Bunga",
            gradientColors = listOf(
                Color(0xFF0D370D),
                Color(0xFF0D370D).copy(alpha = 0.5f),
                Color.White.copy(alpha = 0.5f)
            ),
            onClick = { navController.navigate("edukasi_tanaman_hias") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        CategoryItem(
            imageRes = R.drawable.hiasdaun,
            title = "Tanaman Hias Daun",
            gradientColors = listOf(
                Color(0xFF0B2B0F),
                Color(0xFF0B2B0F).copy(alpha = 0.5f),
                Color.White.copy(alpha = 0.5f)
            ),
            onClick = { navController.navigate("edukasi_tanaman_hias_daun") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        CategoryItem(
            imageRes = R.drawable.hiasbatang,
            title = "Tanaman Hias Batang",
            gradientColors = listOf(
                Color(0xFF0D370D),
                Color(0xFF0D370D).copy(alpha = 0.5f),
                Color.White.copy(alpha = 0.5f)
            ),
            onClick = { navController.navigate("edukasi_tanaman_hias_batang") }
        )
    }
}

@Composable
fun CategoryItem(
    imageRes: Int,
    title: String,
    gradientColors: List<Color>,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(105.dp)
            .clickable { onClick() }
    ) {
        // Background Image
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Image for $title",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        // Gradient Overlay and Text
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = gradientColors
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            )
        }
    }
}
