package com.example.goagroverse.ui.komunitas

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.goagroverse.R



@Composable
fun KomunitasScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFFFF))
            .padding(16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "AgroVerse",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF269D26),
                        textAlign = TextAlign.Center
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Hallo",
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF303030)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Webinar Card
        ContentCard(
            imageResId = R.drawable.forum_webinar,
            title = "Forum Webinar",
            onClick = { navController.navigate("forumWebinar") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Forum Diskusi Card
        ContentCard(
            imageResId = R.drawable.forum_diskusi,
            title = "Forum Diskusi",
            onClick = { navController.navigate("forumDiskusi") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Konsultasi Card
        ContentCard(
            imageResId = R.drawable.forum_konsultasi,
            title = "Konsultasi dengan Ahli",
            onClick = { navController.navigate("konsultasi") }
        )
    }
}

@Composable
fun ContentCard(
    imageResId: Int,
    title: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(153.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, Color(0xFF8A998A), RoundedCornerShape(16.dp))
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .align(Alignment.BottomStart)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF8A998A).copy(alpha = 0.0f),
                            Color(0xFF0A2C0F).copy(alpha = 0.9f)
                        )
                    )
                )
        )

        Text(
            text = title,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight(900),
                color = Color(0xFFFFFFFF),
            ),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewKomunitasScreen() {
    val mockNavController = NavHostController(LocalContext.current)

    KomunitasScreen(navController = mockNavController)
}