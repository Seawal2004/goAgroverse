package com.example.goagroverse.ui.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotifikasiScreen(
    navController: NavController
) {
    var notifications by remember { mutableStateOf((1..10).map { "Selamat Anda mendapatkan diskon 10% untuk pembelian pupuk organik di marketplace AgriVanea." }) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notifikasi") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF8BC34A),
                    titleContentColor = Color.White
                )
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(notifications.size) { index ->
                NotificationItem(
                    message = notifications[index],
                    onDelete = {
                        notifications = notifications.toMutableList().apply {
                            removeAt(index)
                        }
                    }
                )
            }
        }
    }
}




@Composable
fun NotificationItem(
    message: String,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_agroferse),
            contentDescription = "Notification Icon",
            modifier = Modifier
                .size(40.dp)
                .padding(8.dp)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        ) {
            Text(
                text = message,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
        }

        IconButton(onClick = onDelete) {
            Icon(
                painter = painterResource(id = R.drawable.icon_silang),
                contentDescription = "Delete",
                tint = Color.Gray
            )
        }
    }
}

