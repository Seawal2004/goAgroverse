package com.example.goagroverse.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goagroverse.R

@Composable
fun RegisterScreen(
    onNavigateToLogin: () -> Unit,
    onBackToOnboarding: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isConfirmPasswordVisible by remember { mutableStateOf(false) }
    var isFormValid by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(id = R.drawable.loginnn),
            contentDescription = null,
            modifier = Modifier
                .size(240.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    color = Color(0xFF78DE78),
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                )
                .padding(24.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Daftar Akun",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(24.dp))

                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Masukan nama") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                )

                Spacer(modifier = Modifier.height(6.dp))

                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Masukan alamat email") },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 6.dp)
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                )

                Spacer(modifier = Modifier.height(6.dp))

                TextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Masukan nomor telepon") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                )

                Spacer(modifier = Modifier.height(6.dp))

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Masukan kata sandi") },
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                )

                Spacer(modifier = Modifier.height(6.dp))

                TextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text("Masukan kembali kata sandi") },
                    visualTransformation = if (isConfirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (password == confirmPassword && email.isNotBlank()) {
                            isFormValid = true
                        } else {
                            isFormValid = false
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF269D26))
                ) {
                    Text("Daftar", color = Color.White)
                }

                if (!isFormValid) {
                    Text(
                        text = "Mohon periksa kembali data Anda",
                        color = Color.Red,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                TextButton(onClick = onNavigateToLogin) {
                    Text("Sudah punya akun? Masuk", color = Color.Blue)
                }
            }
        }
    }
}
