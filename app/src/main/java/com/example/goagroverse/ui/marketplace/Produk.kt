package com.example.goagroverse.ui.marketplace

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.goagroverse.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProdukScreen(
    navController: NavController,
    productName: String = "Pupuk Latera",
    productImageResId: Int = R.drawable.produk_pupuklatera,
    productPrice: String = "Rp 110.000"
) {
    var quantity by remember { mutableStateOf(1) }
    var selectedVariant by remember { mutableStateOf("Oren") }
    var note by remember { mutableStateOf("") }

    // Warna tombol sesuai desain
    val buttonPrimaryColor = Color(0xFF4CAF50)
    val buttonSecondaryColor = Color.LightGray
    val buttonTextColor = Color.White

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Alat & Bahan") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
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
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                // Product Image
                Image(
                    painter = painterResource(id = productImageResId),
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Product Info
                Text(
                    text = productName,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = productPrice,
                    style = MaterialTheme.typography.headlineSmall.copy(color = Color.Black)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_star),
                        contentDescription = "Rating",
                        tint = Color(0xFFFFC107)
                    )
                    Text(
                        text = "4.5",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Variant Selector
                Text(
                    text = "Pilih Varian",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf("Putih", "Merah", "Oren", "Kuning").forEach { variant ->
                        Button(
                            onClick = { selectedVariant = variant },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (selectedVariant == variant) buttonPrimaryColor else buttonSecondaryColor,
                                contentColor = if (selectedVariant == variant) buttonTextColor else Color.Black
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(text = variant)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Quantity Selector
                Text(
                    text = "Kuantitas",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Minus Button
                    Button(
                        onClick = { if (quantity > 1) quantity-- },
                        colors = ButtonDefaults.buttonColors(containerColor = buttonSecondaryColor),
                        shape = RoundedCornerShape(50)
                    ) {
                        Text("-", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
                    }

                    // Quantity Display
                    Text(
                        text = quantity.toString(),
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    // Plus Button
                    Button(
                        onClick = { quantity++ },
                        colors = ButtonDefaults.buttonColors(containerColor = buttonPrimaryColor),
                        shape = RoundedCornerShape(50)
                    ) {
                        Text("+", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, color = buttonTextColor))
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Note Section
                Text(
                    text = "Catatan",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                BasicTextField(
                    value = note,
                    onValueChange = { note = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                        .padding(8.dp),
                    textStyle = TextStyle(fontSize = 14.sp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Bottom Buttons
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        navController.navigate("payment/$productName/$productPrice")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = buttonPrimaryColor),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(text = "Beli Sekarang", color = buttonTextColor)
                }
                OutlinedButton(
                    onClick = { /* Add to Cart */ },
                    colors = ButtonDefaults.outlinedButtonColors(contentColor = buttonPrimaryColor),
                    modifier = Modifier.weight(1f),
                    border = BorderStroke(1.dp, buttonPrimaryColor)
                ) {
                    Text(text = "+ Keranjang")
                }
            }
        }
    }
}
