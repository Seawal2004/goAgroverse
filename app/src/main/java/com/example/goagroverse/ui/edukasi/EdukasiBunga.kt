package com.example.goagroverse.ui.edukasi

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.goagroverse.R

@Composable
fun EdukasiBunga(navController: NavHostController) {
    val flowers = listOf(
        Pair("Anggrek", R.drawable.bunga_anggrek),
        Pair("Kirisan", R.drawable.bunga_kirisan),
        Pair("Kertas", R.drawable.bunga_kertas),
        Pair("Aglonema", R.drawable.bunga_aglonema),
        Pair("Matahari", R.drawable.bunga_matahari),
        Pair("Peacelily", R.drawable.bunga_peacelily),
        Pair("Daisy", R.drawable.bunga_daisy),
        Pair("Lidah mertua", R.drawable.bunga_lidshmertus),
        Pair("Melati", R.drawable.bunga_melati)

    )

    var searchQuery by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Edukasi",
                fontSize = 20.sp,
                modifier = Modifier.weight(1f),
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Pencarian") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Jenis Tanaman Hias",
            fontSize = 18.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        val filteredFlowers = if (searchQuery.isNotEmpty()) {
            flowers.filter { it.first.contains(searchQuery, ignoreCase = true) }
        } else {
            flowers
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(filteredFlowers) { flower ->
                FlowerItem(
                    name = flower.first,
                    imageRes = flower.second,
                    onClick = {
                        navController.navigate("metodeTanam/${flower.first}")
                    }
                )
            }
        }
    }
}

@Composable
fun FlowerItem(name: String, imageRes: Int, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .width(100.dp)
            .clickable { onClick() }, // Tambahkan klik
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .border(1.dp, Color.Green, RoundedCornerShape(8.dp))
        )
        Text(
            text = name,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp),
            color = Color.Black
        )
    }
}