package com.example.truckmarket.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.truckmarket.ui.navigation.AppDestination
import com.example.truckmarket.ui.navigation.bottomNavDestinations
import com.example.truckmarket.ui.theme.AccentOrange
import com.example.truckmarket.ui.theme.SurfaceDark
import com.example.truckmarket.ui.theme.TextSecondary

@Composable
fun BottomNavBar(
    currentRoute: String?,
    onNavigate: (AppDestination) -> Unit,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier
            .navigationBarsPadding()
            .height(78.dp),
        containerColor = SurfaceDark,
        tonalElevation = 0.dp,
    ) {
        bottomNavDestinations.forEach { destination ->
            val selected = currentRoute == destination.route
            NavigationBarItem(
                selected = selected,
                onClick = { onNavigate(destination) },
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = destination.label,
                    )
                },
                label = { Text(text = destination.label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = AccentOrange,
                    selectedTextColor = Color.White,
                    indicatorColor = SurfaceDark.copy(alpha = 0.0f),
                    unselectedIconColor = TextSecondary,
                    unselectedTextColor = TextSecondary,
                ),
                alwaysShowLabel = true,
            )
        }
    }
}
