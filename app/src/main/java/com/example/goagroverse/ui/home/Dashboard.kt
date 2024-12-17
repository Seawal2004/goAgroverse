package com.example.goagroverse.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.goagroverse.R

@Composable
fun DashboardScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        // Header AgroVerse
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "AgroVerse",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4CAF50)
            )
        }

        // Header: Hallo dan Keranjang
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Hallo Syawal",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            IconButton(onClick = { navController.navigate("keranjang") }) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Keranjang",
                    tint = Color.Black
                )
            }
        }

        // Banner
        Image(
            painter = painterResource(id = R.drawable.banner), // Pastikan resource tersedia
            contentDescription = "Dashboard Banner",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )

        // Teks "Direkomendasikan untuk Anda"
        Text(
            text = "Direkomendasikan untuk Anda",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Penataan LazyRow
        LazyRow(modifier = Modifier.padding(vertical = 8.dp)) {
            items(getRecommendedPlants()) { plant ->
                PlantItem(plantName = plant.name, imageId = plant.imageResId)
            }
        }

        LazyRow(modifier = Modifier.padding(vertical = 8.dp)) {
            items(getRecommendedPlants()) { plant ->
                PlantItem(plantName = plant.name, imageId = plant.imageResId)
            }
        }
    }
}

@Composable
fun PlantItem(plantName: String, imageId: Int) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .width(140.dp),
//        elevation = 4.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "Plant Image",
                modifier = Modifier
                    .size(110.dp)
                    .padding(8.dp)
            )
            Text(
                text = plantName,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}



data class Plant(val name: String, val imageResId: Int)

fun getRecommendedPlants(): List<Plant> {
    return listOf(
        Plant("Matahari", R.drawable.bunga_matahari),
        Plant("Daisy", R.drawable.bunga_daisy),
        Plant("Anggrek", R.drawable.bunga_anggrek),
        Plant("Aglonema", R.drawable.bunga_aglonema),
        Plant("Lidah Mertua", R.drawable.bunga_lidshmertus),
        Plant("Peace Lily", R.drawable.bunga_peacelily)
    )
}