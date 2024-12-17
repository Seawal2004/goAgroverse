package com.example.agroverse.ui_1.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.painter.Painter
import androidx.navigation.NavController
import com.example.goagroverse.R

@Composable
fun ChatScreen(navController: NavController) {
    var messages by remember { mutableStateOf(listOf<Pair<Boolean, String>>()) }
    var currentInput by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Daftar Pesan
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            messages.forEach { (isExpert, message) ->
                ChatBubble(
                    isExpert = isExpert,
                    name = if (isExpert) "Dr. Budi Santoso" else "",
                    profileImage = if (isExpert) painterResource(id = R.drawable.dr_budi) else null,
                    message = message
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        // Input Pesan
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color(0xFFF0F0F0), shape = RoundedCornerShape(16.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                value = currentInput,
                onValueChange = { currentInput = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                decorationBox = { innerTextField ->
                    if (currentInput.text.isEmpty()) {
                        Text(
                            text = "Ketik pesan di sini...",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    }
                    innerTextField()
                }
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Tombol Kirim
            Image(
                painter = painterResource(id = R.drawable.icon_massage),
                contentDescription = "Kirim",
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        if (currentInput.text.isNotBlank()) {
                            // Tambahkan pesan pengguna
                            messages = messages + (false to currentInput.text)

                            // Tambahkan balasan dari ahli
                            messages = messages + (true to "Balasan untuk: ${currentInput.text}")

                            // Reset input
                            currentInput = TextFieldValue("")
                        }
                    }
            )
        }
    }
}

@Composable
fun ChatBubble(
    isExpert: Boolean,
    name: String = "",
    profileImage: Painter? = null,
    message: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = if (isExpert) Arrangement.Start else Arrangement.End
    ) {
        if (isExpert) {
            Image(
                painter = profileImage ?: painterResource(id = R.drawable.dr_siti),
                contentDescription = "Foto Profil",
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Gray, shape = CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
        }

        Column(
            modifier = Modifier
                .background(
                    color = if (isExpert) Color(0xFF269D26) else Color(0xFFE0E0E0),
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(12.dp)
        ) {
            if (isExpert && name.isNotBlank()) {
                Text(
                    text = name,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Text(
                text = message,
                fontSize = 14.sp,
                color = if (isExpert) Color.White else Color.Black
            )
        }
    }
}
