package com.example.goagroverse.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.goagroverse.R

@Composable
fun DashboardScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        HeaderSection(navController)
        SearchBar()
        Spacer(modifier = Modifier.height(4.dp))
        BannerSection()
        Spacer(modifier = Modifier.height(4.dp))

        SectionTitle(title = "Direkomendasikan untuk Anda", subtitle = "Edukasi", seeMoreAction = { })
        Spacer(modifier = Modifier.height(4.dp))
        LazyRow(
            modifier = Modifier.padding(2.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(getRecommendedPlants()) { plant ->
                ProductItem(plant.name, plant.imageResId, "Rp 80.000")
            }
        }

        Spacer(modifier = Modifier.height(2.dp))

        SectionTitle(title = "", subtitle = "Pemasaran", seeMoreAction = { })
        Spacer(modifier = Modifier.height(4.dp))
        LazyRow(
            modifier = Modifier.padding(2.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(getToolsAndSupplies()) { tool ->
                ProductItem(tool.name, tool.imageResId, "Rp 110.000")
            }
        }
    }
}

@Composable
fun HeaderSection(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "AgroVerse",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4CAF50)
        )
        Spacer(modifier = Modifier.height(2.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Hallo",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            IconButton(onClick = { navController.navigate("keranjang") }) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Keranjang",
                    tint = Color.Black
                )
            }
        }
    }
}

@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = { Text("Pencarian") },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Search")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),
        shape = RoundedCornerShape(12.dp)
    )
}

@Composable
fun BannerSection() {
    Image(
        painter = painterResource(id = R.drawable.banner),
        contentDescription = "Promotional Banner",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(165.dp)
            .padding(4.dp)
    )
}

@Composable
fun SectionTitle(title: String, subtitle: String, seeMoreAction: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            if (title.isNotEmpty()) {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
            }
            Text(
                text = subtitle,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
        }
        TextButton(onClick = seeMoreAction) {
            Text(
                text = "Selengkapnya",
                color = Color(0xFF4CAF50)
            )
        }
    }
}

@Composable
fun ProductItem(name: String, imageId: Int, price: String) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .shadow(2.dp, RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(75.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = name, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = price, fontSize = 10.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "+Keranjang",
                fontSize = 10.sp,
                modifier = Modifier
                    .clickable { /* Tambah ke keranjang */ },
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

// Data
data class Product(val name: String, val imageResId: Int)

fun getRecommendedPlants(): List<Product> {
    return listOf(
        Product("Anggrek", R.drawable.bunga_anggrek),
        Product("Aglonema", R.drawable.bunga_aglonema),
        Product("Kaktus", R.drawable.batang_kaktus),
        Product("Suplir", R.drawable.daun_suplir)
    )
}

fun getToolsAndSupplies(): List<Product> {
    return listOf(
        Product("Pupuk Latera", R.drawable.produk_pupuklatera),
        Product("Guntingan Tanaman", R.drawable.produk_guntingtanaman),
        Product("Cangkul Roda", R.drawable.produk_cangkulroda),
        Product("Set Gardening", R.drawable.produk_setgardening)
    )
}