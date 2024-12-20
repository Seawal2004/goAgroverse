package com.example.goagroverse.ui.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.goagroverse.R

@Composable
fun SettingsScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00C853))
    ) {
        HeaderSection(navController)
        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White, shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MenuSection(navController)
                Spacer(modifier = Modifier.height(24.dp))
                ImageSection()
                Spacer(modifier = Modifier.height(24.dp))
                LogoutButton()
            }
        }
    }
}

@Composable
fun MenuSection(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        MenuItem(
            title = "Notifikasi",
            iconResId = R.drawable.icon_notifikasi,
            onClick = {
                println("Navigating to Notification Screen")
                navController.navigate("notificationScreen")
            }
        )
        Divider(color = Color.Gray, thickness = 0.5.dp)

        MenuItem(
            title = "Masukan",
            iconResId = R.drawable.icon_masukan,
            onClick = {
                println("Navigating to Masukan Screen")
                navController.navigate("masukanScreen")
            }
        )
        Divider(color = Color.Gray, thickness = 0.5.dp)

        MenuItem(
            title = "Tentang Kami",
            iconResId = R.drawable.icon_tentangkami,
            onClick = {
                println("Navigating to Tentang Kami Screen")
                navController.navigate("tentangKamiScreen")
            }
        )
    }
}

@Composable
fun MenuItem(title: String, iconResId: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .background(Color.Transparent)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = title,
            modifier = Modifier.size(24.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
    }
}

@Composable
fun ImageSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.setting_image),
            contentDescription = "Flower",
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun LogoutButton() {
    Button(
        onClick = { /* Handle logout */ },
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00C853)),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(text = "Keluar", color = Color.White)
    }
}

@Composable
fun HeaderSection(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Foto profil
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(Color.White, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.setting_profil),
                    contentDescription = "Profile Picture",
                    modifier = Modifier.size(80.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Teks profil
            Column {
                Text(
                    text = "Syawal",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "Mahasiswa",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Black
                )
                Text(
                    text = "Indonesia",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Black
                )

                // Tombol Edit Profil di bawah teks
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { navController.navigate("editProfil") },
                    modifier = Modifier.height(36.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    shape = RoundedCornerShape(18.dp)
                ) {
                    Text(
                        text = "Edit Profil",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF00C853)
                    )
                }
            }
        }
    }
}

