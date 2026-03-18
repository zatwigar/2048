package com.example.truckmarket.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.ListAlt
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppDestination(
    val route: String,
    val label: String,
    val icon: ImageVector,
) {
    data object Search : AppDestination("search", "Поиск", Icons.Outlined.Search)
    data object Favorites : AppDestination("favorites", "Избранное", Icons.Outlined.FavoriteBorder)
    data object Ads : AppDestination("ads", "Объявления", Icons.Outlined.ListAlt)
    data object Messages : AppDestination("messages", "Сообщения", Icons.Outlined.ChatBubbleOutline)
    data object Menu : AppDestination("menu", "Меню", Icons.Outlined.Menu)
}

val bottomNavDestinations = listOf(
    AppDestination.Search,
    AppDestination.Favorites,
    AppDestination.Ads,
    AppDestination.Messages,
    AppDestination.Menu,
)
