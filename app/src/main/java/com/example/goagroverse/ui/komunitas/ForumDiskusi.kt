package com.example.goagroverse.ui.komunitas

import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.material3.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.goagroverse.R

@Composable
fun ForumDiskusiScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Title
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp), // Menambahkan padding bawah
            contentAlignment = Alignment.Center // Memastikan teks berada di tengah
        ) {
            Text(
                text = "AgroVerse",
                style = TextStyle(
                    fontSize = 18.sp, // Ukuran teks yang lebih besar agar terlihat lebih jelas
//                    fontFamily = FontFamily(Font(R.font.radley)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF269D26),
                    textAlign = TextAlign.Center
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Welcome Message
        Text(
            text = "Hallo, Syawal",
            style = TextStyle(
                fontSize = 15.sp,
//                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                fontWeight = FontWeight(500),
                color = Color(0xFF303030)
            ),
            modifier = Modifier
                .fillMaxWidth() // Menambahkan agar teks berada di tengah
                .padding(bottom = 16.dp) // Jarak ke elemen berikutnya
        )

        // Post input field
        Box(
            modifier = Modifier
                .border(1.dp, Color(0xFF269D26), RoundedCornerShape(10.dp))
                .fillMaxWidth() // Menggunakan fillMaxWidth agar mengikuti layar
                .height(91.dp)
        ) {
            Text(
                text = "Tulis postingan...",
                style = TextStyle(
                    fontSize = 13.sp,
//                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF303030),
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.TopStart)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Send Button
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd // Memastikan tombol ada di kanan bawah
        ) {
            Button(
                onClick = { /* TODO: Tambahkan aksi */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF269D26)),
                modifier = Modifier
                    .padding(end = 8.dp) // Jarak dari kanan layar
                    .size(width = 80.dp, height = 40.dp) // Ukuran tombol diperbesar
            ) {
                Text(
                    text = "Kirim",
                    style = TextStyle(
                        fontSize = 14.sp, // Sedikit diperbesar untuk keterbacaan
//                        fontFamily = FontFamily(Font(R.font.poppins_bold)),
                        fontWeight = FontWeight(500),
                        color = Color.White // Warna teks kontras untuk keterbacaan
                    ),
                    textAlign = TextAlign.Center // Memastikan teks berada di tengah
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Discussion Boxes
        DiscussionBox(
            name = "Udin",
            time = "23 Oktober 2024, 19.33",
            content = "Lihat koleksi tamananku!!",
            imagePainter = painterResource(id = R.drawable.post_udin),
            likes = 9,
            comments = 2
        )

        Spacer(modifier = Modifier.height(8.dp))

        DiscussionBox(
            name = "Udin",
            time = "28 Oktober 2024, 19.33",
            content = "Adakah saran warna bunga yang harus aku beli jika cat rumah berwarna coklat?",
            imagePainter = null,
            likes = 6,
            comments = 3
        )
    }
}

@Composable
fun DiscussionBox(
    name: String,
    time: String,
    content: String,
    imagePainter: Painter?,
    likes: Int,
    comments: Int
) {
    Column(
        modifier = Modifier
            .border(1.dp, Color(0xFF269D26), RoundedCornerShape(10.dp))
            .width(373.dp)
            .padding(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.profil_udin),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = name,
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF303030)
                    )
                )

                Text(
                    text = time,
                    style = TextStyle(
                        fontSize = 7.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF303030)
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = content,
            style = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF303030)
            )
        )

        if (imagePainter != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = imagePainter,
                contentDescription = "Post Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(101.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            Icon(
                painter = painterResource(id = R.drawable.icon_like),
                contentDescription = "Like Icon",
                modifier = Modifier.size(16.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = likes.toString(),
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF303030)
                )
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                painter = painterResource(id = R.drawable.icon_comment),
                contentDescription = "Comment Icon",
                modifier = Modifier.size(24.dp),
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = comments.toString(),
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF303030)
                )
            )
        }
    }
}