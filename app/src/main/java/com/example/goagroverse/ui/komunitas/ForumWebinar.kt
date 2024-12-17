package com.example.goagroverse.ui.komunitas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.goagroverse.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForumWebinar(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(5.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "AgroVerse",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.White,
                titleContentColor = Color(0xFF269D26)
            )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Search Bar
            OutlinedTextField(
                value = "",
                onValueChange = { },
                placeholder = { Text("Search") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon"
                    )
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Image Carousel
            Image(
                painter = painterResource(id = R.drawable.icon_webinar),
                contentDescription = "Carousel Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(10.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Webinar Section Title
            Text(
                text = "Webinar yang akan datang:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF303030)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Webinar List
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(3) { index ->
                    WebinarItem(
                        title = when (index) {
                            0 -> "Membangun Bisnis Tanaman Hias dari Hobi"
                            1 -> "Mengoptimalkan Media Sosial untuk Pemasaran Tanaman Hias"
                            else -> "Manfaat Terapi Hortikultura untuk Kesehatan Mental"
                        },
                        speaker = when (index) {
                            0 -> "Ir. Farah Indriani – Konsultan Bisnis dan Pengusaha Tanaman Hias"
                            1 -> "Taufik Ramaditya – Spesialis Digital Marketing dan Influencer Tanaman Hias"
                            else -> "Dr. Aditya Nugraha – Psikolog dan Peneliti Terapi Hortikultura"
                        },
                        description = when (index) {
                            0 -> "Webinar ini cocok bagi para pegiat tanaman hias yang ingin mengembangkan hobi menjadi bisnis menguntungkan."
                            1 -> "Taufik akan membagikan strategi meningkatkan pemasaran di media sosial."
                            else -> "Dr. Aditya akan menjelaskan bagaimana tanaman hias dapat membantu kesehatan mental."
                        },
                        imageRes = when (index) {
                            0 -> R.drawable.pemateri1
                            1 -> R.drawable.pemateri2
                            else -> R.drawable.pemateri3
                        },
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
fun WebinarItem(
    title: String,
    speaker: String,
    description: String,
    imageRes: Int,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF269D26), shape = RoundedCornerShape(10.dp))
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // Header (Image and Titles)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                // Image
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(68.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .align(Alignment.CenterVertically)
                        .padding(end = 16.dp)
                )

                // Titles
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = title,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = speaker,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                    )
                }
            }

            // Description
            Text(
                text = description,
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

            // Button
            Button(
                onClick = { navController.navigate("pendaftaran") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(
                    text = "Daftar",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF269D26)
                    )
                )
            }
        }
    }
}

