package com.example.goagroverse.ui.setting

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.goagroverse.R

// Define custom green color
val GreenColor = Color(0xFF269D26)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfile(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit Profil", style = MaterialTheme.typography.titleLarge) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = GreenColor)
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            // Profile Picture Section
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(GreenColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.setting_profil),
                    contentDescription = "Foto Profil",
                    modifier = Modifier.size(90.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Form Fields
            CustomTextField(label = "Nama", value = "")
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(label = "Email", value = "")
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(label = "Nomor Telepon", value = "")
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(label = "Alamat", value = "")
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(label = "Password", value = "", isPassword = true)

            Spacer(modifier = Modifier.height(24.dp))

            // Save and Cancel Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(containerColor = GreenColor)
                ) {
                    Text("Batal", color = Color.White)
                }
                Button(
                    onClick = {
                        // Logika untuk menyimpan data
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = GreenColor)
                ) {
                    Text("Simpan", color = Color.White)
                }
            }
        }
    }
}

@Composable
fun CustomTextField(label: String, value: String, isPassword: Boolean = false) {
    val textState = remember { mutableStateOf(value) }
    OutlinedTextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        label = { Text(label) },
        singleLine = true,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        textStyle = TextStyle(color = Color.Black)
    )
}

@Composable
@Preview(showBackground = true)
fun EditProfileScreenPreview() {
    val navController = rememberNavController()
    EditProfile(navController)
}
