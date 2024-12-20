package com.example.goagroverse.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goagroverse.R

@Composable
fun OnBoardingScreen(
    onNavigateToLogin: () -> Unit
) {
    val pages = listOf(
        OnboardingData(R.drawable.logo_agroverse, "Agroverse", "Selamat Datang Di Agroverse"),
        OnboardingData(R.drawable.ob1, "Edukasi Perawatan Tanaman", "Pelajari cara merawat tanaman hias dengan mudah melalui panduan interaktif dan video tutorial."),
        OnboardingData(R.drawable.ob2, "Belanja Aman dan Praktis", "Nikmati kemudahan berbelanja dengan pembayaran yang aman dan pilihan pengiriman sesuai kebutuhanmu."),
        OnboardingData(R.drawable.ob3, "Forum Komunitas", "Menciptakan ruang yang positif untuk berbagi pengetahuan dan pengalaman. Manfaatkan webinar, forum diskusi, dan konsultasi ahli untuk mencapai tujuanmu.")
    )

    var currentPage by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (currentPage < pages.size) {
            val page = pages[currentPage]
            OnboardingPage(
                imageId = page.imageId,
                title = page.title,
                description = page.description,
                onNext = {
                    if (currentPage < pages.size - 1) {
                        currentPage++
                    } else {
                        onNavigateToLogin()
                    }
                }
            )
        }
    }
}

@Composable
fun OnboardingPage(imageId: Int, title: String, description: String, onNext: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = title,
            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = description,
            style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onNext,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
            shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .width(200.dp)
                .height(48.dp)
        ) {
            Text(
                text = if (title == "Forum Komunitas") "Selesai" else "Selanjutnya",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

data class OnboardingData(val imageId: Int, val title: String, val description: String)
