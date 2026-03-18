package com.example.truckmarket.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.truckmarket.ui.components.BottomNavBar
import com.example.truckmarket.ui.screens.AdsScreen
import com.example.truckmarket.ui.screens.FavoritesScreen
import com.example.truckmarket.ui.screens.MenuScreen
import com.example.truckmarket.ui.screens.MessagesScreen
import com.example.truckmarket.ui.screens.SearchScreen

@Composable
fun TruckMarketApp() {
    val navController = rememberNavController()
    val currentBackStack = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack.value?.destination?.route

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavBar(
                currentRoute = currentRoute,
                onNavigate = { destination ->
                    navController.navigate(destination.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        },
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppDestination.Search.route,
            modifier = Modifier.fillMaxSize(),
        ) {
            composable(AppDestination.Search.route) { SearchScreen(modifier = Modifier.padding(innerPadding)) }
            composable(AppDestination.Favorites.route) { FavoritesScreen(modifier = Modifier.padding(innerPadding)) }
            composable(AppDestination.Ads.route) { AdsScreen(modifier = Modifier.padding(innerPadding)) }
            composable(AppDestination.Messages.route) { MessagesScreen(modifier = Modifier.padding(innerPadding)) }
            composable(AppDestination.Menu.route) { MenuScreen(modifier = Modifier.padding(innerPadding)) }
        }
    }
}
