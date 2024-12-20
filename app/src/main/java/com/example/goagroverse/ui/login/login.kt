package com.example.goagroverse.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goagroverse.R

@Composable
fun LoginScreen(
    onNavigateToRegister: () -> Unit,
    onBackToOnboarding: () -> Unit,
    onNavigateToDashboard: () -> Unit,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }
    var loginError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.loginnn),
            contentDescription = null,
            modifier = Modifier.size(240.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color(0xFF78DE78), shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Selamat Datang",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "Masuk dengan Akun",
                fontSize = 18.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(32.dp))

            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Kata Sandi") },
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .background(Color.White, shape = RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = rememberMe,
                        onCheckedChange = { rememberMe = it },
                        colors = CheckboxDefaults.colors(checkmarkColor = Color.White, uncheckedColor = Color.Gray)
                    )
                    Text(text = "Ingat saya", color = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        onNavigateToDashboard()
                    } else {
                        loginError = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF269D26))
            ) {
                Text("Masuk", color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Atau", color = Color.Gray, fontSize = 14.sp)

            Spacer(modifier = Modifier.height(14.dp))

            Button(
                onClick = { /* Add Google sign-in logic here */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(24.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_google),
                    contentDescription = "Google logo",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Masuk dengan Google", color = Color.Gray)
            }

            Spacer(modifier = Modifier.height(14.dp))

            TextButton(onClick = onNavigateToRegister) {
                Text("Belum punya akun? Daftar sekarang", color = Color.Blue)
            }
        }
    }
}
