package com.example.goagroverse.fungsinavhost

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.agroverse.ui_1.components.ChatScreen
import com.example.appagroverse.EdukasiScreen
import com.example.goagroverse.R
import com.example.goagroverse.navigationbar.BottomBar
import com.example.goagroverse.navigationbar.PreferencesHelper
import com.example.goagroverse.navigationbar.Screen
import com.example.goagroverse.ui.edukasi.EdukasiBunga
import com.example.goagroverse.ui.edukasi.MetodeTanam
import com.example.goagroverse.ui.edukasi.PengendalianHama
import com.example.goagroverse.ui.edukasi.TeknikPerawatan
import com.example.goagroverse.ui.home.DashboardScreen
import com.example.goagroverse.ui.komunitas.FormulirPendaftaran
import com.example.goagroverse.ui.komunitas.ForumDiskusiScreen
import com.example.goagroverse.ui.komunitas.ForumKonsultasiScreen
import com.example.goagroverse.ui.komunitas.ForumWebinar
import com.example.goagroverse.ui.komunitas.KomunitasScreen
import com.example.goagroverse.ui.onboarding.OnBoardingScreen
import com.example.goagroverse.ui.login.LoginScreen
import com.example.goagroverse.ui.login.RegisterScreen
import com.example.goagroverse.ui.marketplace.MarketScreen
import com.example.goagroverse.ui.marketplace.NotaPembayaran
import com.example.goagroverse.ui.marketplace.PembayaranScreen
import com.example.goagroverse.ui.marketplace.ProdukScreen
import com.example.goagroverse.ui.setting.EditProfile
import com.example.goagroverse.ui.setting.SettingsScreen
import com.example.goagroverse.ui.setting.NotifikasiScreen
import com.example.goagroverse.ui.setting.MasukanScreen
import com.example.goagroverse.ui.setting.TentangKamiScreen
import com.example.shoppingcart.Keranjang

@Composable
fun AgroverseApp(
    context: Context,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val preferencesHelper = remember { PreferencesHelper(context) }
    val initialRoute = when {
        !preferencesHelper.isOnboardingCompleted() -> "onboarding"
        !preferencesHelper.isLoggedIn() -> "login"
        else -> "main"
    }

    Scaffold(
        bottomBar = {
            val navBackStackEntry = navController.currentBackStackEntryAsState().value
            val currentRoute = navBackStackEntry?.destination?.route
            if (currentRoute in listOf(
                    "main", Screen.Dashboard.route, Screen.Edukasi.route,
                    Screen.Market.route, Screen.Komunitas.route, Screen.Setting.route
                )
            ) {
                BottomBar(navController = navController)
            }
        }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = initialRoute,
            modifier = modifier.padding(contentPadding)
        ) {
            // Onboarding
            composable("onboarding") {
                OnBoardingScreen(
                    onNavigateToLogin = {
                        navController.navigate("login") {
                            popUpTo("onboarding") { inclusive = true }
                        }
                    }
                )
            }

            // Login Screen
            composable("login") {
                LoginScreen(
                    onNavigateToRegister = { navController.navigate("register") },
                    onBackToOnboarding = {
                        navController.navigate("onboarding") {
                            popUpTo("login") { inclusive = true }
                        }
                    },
                    onNavigateToDashboard = {
                        preferencesHelper.setLoggedIn(true) // Simpan status login
                        navController.navigate("dashboard") {
                            popUpTo("login") { inclusive = true }
                        }
                    }

                )
            }

            // Register Screen
            composable("register") {
                RegisterScreen(
                    onNavigateToLogin = { navController.navigate("login") },
                    onBackToOnboarding = {
                        navController.navigate("main") {
                            popUpTo("register") { inclusive = true }
                        }
                    }
                )
            }

            composable(Screen.Dashboard.route) {
                DashboardScreen(navController)
            }
            composable("keranjang") {
                Keranjang(navController)
            }


            //EdukasiScreen
            composable(Screen.Edukasi.route) {
                EdukasiScreen(navController)
            }
            //ItemTanaman
            composable(route = "edukasi_tanaman_hias") {
                EdukasiBunga(navController)
            }
            // Submenu Metode Tanam
            composable(
                route = "metodeTanam/{flowerType}",
                arguments = listOf(navArgument("flowerType") { type = NavType.StringType })
            ) { backStackEntry ->
                val flowerType = backStackEntry.arguments?.getString("flowerType")
                MetodeTanam(navController = navController, flowerType = flowerType)
            }
            // Submenu Teknik Perawatan
            composable(
                route = "teknikPerawatan/{flowerType}",
                arguments = listOf(navArgument("flowerType") { type = NavType.StringType })
            ) { backStackEntry ->
                val flowerType = backStackEntry.arguments?.getString("flowerType")
                TeknikPerawatan(navController = navController, flowerType = flowerType)
            }
            // Submenu Teknik Perawatan
            composable(
                route = "pengendalianHama/{flowerType}",
                arguments = listOf(navArgument("flowerType") { type = NavType.StringType })
            ) { backStackEntry ->
                val flowerType = backStackEntry.arguments?.getString("flowerType")
                PengendalianHama(navController = navController, flowerType = flowerType)
            }



            //Market
            composable(Screen.Market.route) {
                MarketScreen(navController)
            }
            // Product Screen
            composable(
                route = "produk/{name}/{imageResId}/{price}",
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                    navArgument("imageResId") { type = NavType.IntType },
                    navArgument("price") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val name = backStackEntry.arguments?.getString("name") ?: ""
                val imageResId = backStackEntry.arguments?.getInt("imageResId") ?: R.drawable.produk_pupuklatera
                val price = backStackEntry.arguments?.getString("price") ?: ""

                ProdukScreen(
                    navController = navController,
                    productName = name,
                    productImageResId = imageResId,
                    productPrice = price
                )
            }
            //Pembayaran
            composable("pembayaran") {
                PembayaranScreen(
                    productName = "Sample Product",
                    productPrice = "Rp 210.000",
                    navController = navController
                )
            }
            composable(
                route = "payment/{productName}/{productPrice}",
                arguments = listOf(
                    navArgument("productName") { type = NavType.StringType },
                    navArgument("productPrice") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val productName = backStackEntry.arguments?.getString("productName") ?: ""
                val productPrice = backStackEntry.arguments?.getString("productPrice") ?: ""
                PembayaranScreen(productName = productName, productPrice = productPrice, navController = navController)
            }
            //Nota Pembayaran
            composable("nota") {
                NotaPembayaran(navController = navController)
            }



            //Komunitas
            composable(Screen.Komunitas.route) {
                KomunitasScreen(navController)
            }
            //Webinar
            composable("forumWebinar") {
                ForumWebinar(navController)
            }
            //Pendaftaran Webinar
            composable("pendaftaran") {
                FormulirPendaftaran(navController)
            }
            //Diskusi
            composable("forumDiskusi") {
                ForumDiskusiScreen(navController)
            }
            //Konsultasi
            composable(route = "konsultasi") {
                ForumKonsultasiScreen(navController)
            }
            //Chating
            composable("chatAhli") {
                ChatScreen(navController)
            }


            // Setting
            composable(Screen.Setting.route) {
                SettingsScreen(navController)
            }
            composable("editProfil") {
                EditProfile(navController)
            }
            composable("notificationScreen") {
                NotifikasiScreen(navController)
            }
            composable("masukanScreen") {
                MasukanScreen(navController)
            }
            composable("tentangKamiScreen") {
                TentangKamiScreen(navController)
            }
        }
    }
}

//nazla
