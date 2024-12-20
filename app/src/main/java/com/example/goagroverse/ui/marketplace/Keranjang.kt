package com.example.shoppingcart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Keranjang(navController: NavController) {
    Scaffold(
        topBar = {
            AppBar(
                title = "Keranjang",
                onBackClick = { /* Handle back navigation */ }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            // Sample product data
            val productList = listOf(
                "Alat Berkebun - Set Gardening Alat Berkebun isi 5 pcs",
                "Alat Berkebun - Set Gardening Alat Berkebun isi 5 pcs",
                "Alat Berkebun - Set Gardening Alat Berkebun isi 5 pcs"
            )
            val productPrice = 210000

            // List of cart items
            productList.forEachIndexed { index, product ->
                CartItem(
                    productName = product,
                    productPrice = productPrice,
                    onDelete = { /* Handle delete */ }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            Spacer(modifier = Modifier.weight(1f))

            TotalSection(totalPrice = productPrice)
        }
    }
}

@Composable
fun AppBar(title: String, onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CartItem(
    productName: String,
    productPrice: Int,
    onDelete: () -> Unit
) {
    var quantity by remember { mutableStateOf(1) }
    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Green, RoundedCornerShape(8.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Checkbox
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Green,
                uncheckedColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Product image from drawable
        Image(
            painter = painterResource(id = R.drawable.produk_setgardening),
            contentDescription = "Product Image",
            modifier = Modifier
                .size(64.dp)
                .background(Color.LightGray, RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Product details
        Column(modifier = Modifier.weight(1f)) {
            Text(productName, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text("Rp $productPrice", fontSize = 14.sp, color = Color.Black)
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Quantity controls
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            IconButton(onClick = { if (quantity > 1) quantity-- }) {
                Text("-", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
            Text(quantity.toString(), fontSize = 14.sp)
            IconButton(onClick = { quantity++ }) {
                Text("+", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun TotalSection(totalPrice: Int) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Divider(color = Color.Gray, thickness = 1.dp)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Total produk", fontWeight = FontWeight.Bold)
            Text("Rp $totalPrice", fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* Handle buy action */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Beli", color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}

