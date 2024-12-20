package com.example.goagroverse.navigationbar

import androidx.compose.foundation.Image
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.goagroverse.R

@Composable
fun BottomBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_dashboard),
                iconRes = R.drawable.nav_iconberanda,
                screen = Screen.Dashboard
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_edukasi),
                iconRes = R.drawable.nav_iconedukasi,
                screen = Screen.Edukasi
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_market),
                iconRes = R.drawable.nav_iconpasar,
                screen = Screen.Market
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_komunitas),
                iconRes = R.drawable.nav_iconkomunitas,
                screen = Screen.Komunitas
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_setting),
                iconRes = R.drawable.icon_setting,
                screen = Screen.Setting
            )
        )

        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = {
                    Image(
                        painter = painterResource(id = item.iconRes),
                        contentDescription = item.title
                    )
                },
                label = { androidx.compose.material3.Text(text = item.title) }
            )
        }
    }
}
