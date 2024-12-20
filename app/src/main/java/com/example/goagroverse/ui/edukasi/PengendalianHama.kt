package com.example.goagroverse.ui.edukasi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.goagroverse.R

@Composable
fun PengendalianHama(
    navController: NavController,
    flowerType: String?,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        // Tombol Back
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.epback),
                contentDescription = "ep:back",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { navController.popBackStack() }
            )
        }

        // Deskripsi Bunga
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.bunga_anggrek),
                contentDescription = "image bunga anggrek",
                modifier = Modifier
                    .size(128.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .border(1.dp, Color(0xff269d26), shape = RoundedCornerShape(10.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(color = Color(0xff303030), fontSize = 10.sp)
                    ) { append("Anggrek “Orchidaceae” ") }
                    withStyle(
                        style = SpanStyle(color = Color(0xff303030), fontSize = 10.sp)
                    ) { append("merupakan satu suku tumbuhan berbunga dengan anggota jenis terbanyak. Jenis-jenisnya tersebar luas dari daerah tropika basah hingga wilayah sirkumpolar, meskipun sebagian besar anggotanya ditemukan di daerah tropika.") }
                },
                modifier = Modifier.weight(1f),
                fontSize = 10.sp,
                lineHeight = 14.sp,
                color = Color(0xff303030)
            )
        }

        // Header dengan tab
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(BorderStroke(1.dp, Color(0xff269d26)))
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    navController.navigate("metodeTanam/${flowerType ?: "default"}")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(
                    text = "Media Tanam",
                    color = Color(0xff303030),
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Button(
                onClick = {
                    navController.navigate("teknikPerawatan/${flowerType ?: "default"}")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(
                    text = "Teknik Perawatan",
                    color = Color(0xff303030),
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Button(
                onClick = {
                    navController.navigate("pengendalianHama/${flowerType ?: "default"}")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(
                    text = "Pengendalian Hama",
                    color = Color(0xff269d26),
                    textAlign = TextAlign.Center,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        // Konten Utama
        Text(
            text = "Berikut beberapa langkah yang dapat Anda lakukan untuk mengendalikan hama dan penyakit pada anggrek:\n" +
                    "\n1. Identifikasi Hama dan Penyakit" +
                    "\nAmati gejala: Perhatikan perubahan pada daun, batang, akar, atau bunga. Apakah ada bercak, bintik hitam, daun menguning, atau serangga kecil?" +
                    "\nCari tahu penyebabnya: Gunakan buku panduan atau konsultasikan dengan ahli untuk mengetahui jenis hama atau penyakit yang menyerang anggrek Anda." +
                    "\n2. Pengendalian Secara Alami" +
                    "\nInsektisida nabati: Gunakan bahan alami seperti ekstrak daun sirsak, bawang putih, atau cabai untuk mengusir serangga." +
                    "\nPredator alami: Perkenalkan predator alami seperti laba-laba atau serangga tertentu untuk mengendalikan populasi hama." +
                    "\nSanitasi: Bersihkan tanaman secara teratur, buang bagian tanaman yang sakit, dan sterilkan alat-alat yang digunakan." +
                    "\n3. Pengendalian Kimia" +
                    "\nFungisida: Gunakan fungisida yang sesuai untuk mengatasi penyakit yang disebabkan oleh jamur." +
                    "\nInsektisida: Pilih insektisida yang spesifik untuk jenis hama yang menyerang dan ikuti petunjuk penggunaan secara cermat." +
                    "\n4. Pencegahan" +
                    "\nKarantina tanaman baru: Sebelum memasukkan tanaman baru ke dalam koleksi, karantinakan terlebih dahulu untuk mencegah penyebaran hama dan penyakit." +
                    "\nJaga kebersihan lingkungan: Pastikan lingkungan sekitar tanaman bersih dan bebas dari sumber penyakit." +
                    "\nPerhatikan kelembapan: Hindari kondisi terlalu lembap yang dapat memicu pertumbuhan jamur.",
            color = Color(0xff303030),
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )
    }
}

