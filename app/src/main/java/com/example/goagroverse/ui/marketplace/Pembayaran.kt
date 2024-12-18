package com.example.goagroverse.ui.marketplace

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.goagroverse.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PembayaranScreen(
    productName: String = "",
    productPrice: String = "",
    navController: NavController
) {
    var quantity by remember { mutableStateOf(1) }
    val greenColor = Color(0xFF4CAF50) // Hijau sesuai desain

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Pembayaran") },
                navigationIcon = {
                    IconButton(onClick = { /* Back action */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Alamat Pengiriman
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.LocationOn,
                    contentDescription = "Location",
                    tint = Color.Black // Ikon diubah menjadi hitam
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(
                        text = "Alamat pengiriman",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                    )
                    Text(
                        text = "Masukan alamat yang akan dikirim",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Ringkasan Produk
            Card(
                shape = RoundedCornerShape(8.dp),
                border = ButtonDefaults.outlinedButtonBorder,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.produk_pupuklatera),
                        contentDescription = "Product Image",
                        modifier = Modifier
                            .size(80.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "Alat Berkebun",
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                        )
                        Text(
                            text = "Pupuk Latera.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Rp 110.000",
                            style = MaterialTheme.typography.headlineSmall.copy(color = Color.Black)
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    // Quantity Controls
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = { if (quantity > 1) quantity-- }) {
                            Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Minus")
                        }
                        Text(text = quantity.toString(), style = MaterialTheme.typography.bodyLarge)
                        IconButton(onClick = { quantity++ }) {
                            Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Plus")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Pilih Voucher
            OutlinedCard(
                onClick = { /* Navigate to voucher selection */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Pilih voucher", style = MaterialTheme.typography.bodyLarge)
                    Icon(Icons.Default.KeyboardArrowRight, contentDescription = "Arrow Right")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Ringkasan Pembayaran
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Subtotal 1 produk",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "Rp 110.000",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.End)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Total diskon\nTidak ada diskon",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "- Rp 0",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.align(Alignment.End)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Tidak ada voucher digunakan",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Pilih Pengiriman
            OutlinedCard(
                onClick = { /* Navigate to shipping selection */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Pilih pengiriman",
                        style = MaterialTheme.typography.bodyLarge.copy(color = greenColor)
                    )
                    Icon(Icons.Default.KeyboardArrowRight, contentDescription = "Arrow Right", tint = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Pilih Pembayaran
            OutlinedCard(
                onClick = { /* Navigate to payment method selection */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Pilih metode pembayaran",
                        style = MaterialTheme.typography.bodyLarge.copy(color = greenColor)
                    )
                    Icon(Icons.Default.KeyboardArrowRight, contentDescription = "Arrow Right", tint = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Total Harga dan Tombol Bayar
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Total", style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold))
                    Text(
                        text = "Rp 110.000",
                        style = MaterialTheme.typography.headlineSmall.copy(color = Color.Black)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        navController.navigate("nota")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = greenColor)
                ) {
                    Text(text = "Bayar", color = Color.White)
                }
            }
        }
    }
}