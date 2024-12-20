package com.example.goagroverse.ui.komunitas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.goagroverse.R

@Composable
fun FormulirPendaftaran(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        // Header Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF269D26), shape = RoundedCornerShape(10.dp))
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    // Gambar Pembicara
                    Image(
                        painter = painterResource(id = R.drawable.pemateri1),
                        contentDescription = "Webinar Image",
                        modifier = Modifier
                            .size(68.dp)
                            .align(Alignment.CenterVertically)
                            .padding(end = 16.dp)
                    )

                    // Judul dan Subjudul
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Membangun Bisnis Tanaman Hias dari Hobi",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            ),
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = "Ir. Farah Indriani – Konsultan Bisnis dan Pengusaha Tanaman Hias",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.White
                            )
                        )
                    }
                }

                // Deskripsi Webinar
                Text(
                    text = "Webinar ini cocok bagi para pegiat tanaman hias yang ingin mengembangkan hobi menjadi bisnis menguntungkan. Ir. Farah akan berbagi tips pemasaran, manajemen stok, dan pemanfaatan platform digital untuk menjangkau lebih banyak konsumen.",
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Thin,
                        color = Color.White,
                        lineHeight = 14.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                // Informasi Pembicara dan Tanggal Webinar
                Text(
                    text = "Pembicara: Ir. Farah Indriani\nTanggal webinar: 30 Oktober 2024",
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Thin,
                        color = Color.White,
                        lineHeight = 12.sp // Spasi antar baris
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Form Title
        Text(
            text = "Formulir Pendaftaran",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF303030),
                letterSpacing = 0.4.sp
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Input Fields
        InputField(label = "Nama lengkap:")
        Spacer(modifier = Modifier.height(16.dp))
        InputField(label = "E-mail:")
        Spacer(modifier = Modifier.height(16.dp))
        InputField(label = "Nomor telepon:")
        Spacer(modifier = Modifier.height(16.dp))
        InputField(label = "Pekerjaan:")
        Spacer(modifier = Modifier.height(16.dp))
        InputField(label = "Motivasi mengikuti webinar:")
        Spacer(modifier = Modifier.height(16.dp))

        // Checkbox Section
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(vertical = 8.dp)) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .border(1.dp, Color(0xFF303030), RoundedCornerShape(3.dp))
                    .background(color = Color.White)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Saya menyatakan setuju dengan syarat dan ketentuan webinar ini.",
                style = TextStyle(
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFF303030)
                )
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Submit Button
        Button(
            onClick = { /* Submit Action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF269D26)),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .width(170.dp)
                .height(46.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Daftar Sekarang",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp
                ),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
fun InputField(label: String) {
    Column {
        Text(
            text = label,
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color(0xFF303030)
            ),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(46.dp)
                .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                .border(1.dp, Color(0xFF269D26), RoundedCornerShape(10.dp))
        )
    }
}