package com.example.goagroverse.ui.komunitas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.goagroverse.R
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Icon

@Composable
fun ForumKonsultasiScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") } // State untuk teks pencarian

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Teks AgroVerse
        Text(
            text = "AgroVerse",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF269D26),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        // SearchBar
        SearchBar(searchQuery = searchQuery, onQueryChange = { searchQuery = it })

        // Daftar Ahli
        ExpertList(navController = navController, searchQuery = searchQuery)
    }
}

@Composable
fun SearchBar(searchQuery: String, onQueryChange: (String) -> Unit) {
    OutlinedTextField(
        value = searchQuery,
        onValueChange = { onQueryChange(it) },
        placeholder = { Text(text = "Pencarian") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(24.dp)
    )
}

@Composable
fun ExpertList(navController: NavController, searchQuery: String) {
    val experts = listOf(
        "Dr. Budi Santoso" to R.drawable.dr_budi,
        "Prof. Siti Nurhaliza" to R.drawable.dr_siti,
        "Ir. Agus Priyanto, M.Sc." to R.drawable.dr_agus,
        "Dr. Maria Kusuma Dewi" to R.drawable.dr_maria,
        "Prof. Widodo Mahendra" to R.drawable.dr_widodo,
        "Ir. Denny Kurniawan" to R.drawable.dr_deny,
        "Dr. Tri Wahyuni" to R.drawable.dr_tri
    )

    // Filter daftar ahli berdasarkan teks pencarian
    val filteredExperts = experts.filter { it.first.contains(searchQuery, ignoreCase = true) }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(filteredExperts) { expert ->
            val (name, imageRes) = expert
            Konsultasi(
                navController = navController,
                name = name,
                profileImage = painterResource(id = imageRes),
                isActive = false,
                onStatusChange = { isActive ->
                    println("Status $name: $isActive")
                }
            )
        }
    }
}

@Composable
fun Konsultasi(
    navController: NavController,
    name: String,
    profileImage: Painter? = null,
    isActive: Boolean = false,
    onStatusChange: (Boolean) -> Unit = {}
) {
    var status by remember { mutableStateOf(isActive) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(Color(0xFF269D26), shape = RoundedCornerShape(8.dp))
            .clickable { navController.navigate("chatAhli") }
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Gambar Profil
        if (profileImage != null) {
            Image(
                painter = profileImage,
                contentDescription = "Foto profil $name",
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Gray, shape = CircleShape),
                contentScale = ContentScale.Crop
            )
        } else {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Gray, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = name.firstOrNull()?.toString() ?: "",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        // Nama Ahli
        Text(
            text = name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            modifier = Modifier.weight(1f)
        )

        // Ikon pesan
        Image(
            painter = painterResource(
                id = R.drawable.icon_massage
            ),
            contentDescription = "Status $name",
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    status = !status
                    onStatusChange(status)
                }
        )
    }
}
