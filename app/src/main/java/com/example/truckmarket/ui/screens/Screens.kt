package com.example.truckmarket.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.truckmarket.ui.components.EmptyStateCard
import com.example.truckmarket.ui.components.StatsSwitcher
import com.example.truckmarket.ui.components.TopHeader
import com.example.truckmarket.ui.theme.BackgroundBlack
import com.example.truckmarket.ui.theme.TruckMarketTheme

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundBlack)
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        TopHeader()
        StatsSwitcher()
        EmptyStateCard(modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun FavoritesScreen(modifier: Modifier = Modifier) {
    SectionPlaceholderScreen(title = "Экран Избранное", modifier = modifier)
}

@Composable
fun AdsScreen(modifier: Modifier = Modifier) {
    SectionPlaceholderScreen(title = "Экран Объявления", modifier = modifier)
}

@Composable
fun MessagesScreen(modifier: Modifier = Modifier) {
    SectionPlaceholderScreen(title = "Экран Сообщения", modifier = modifier)
}

@Composable
fun MenuScreen(modifier: Modifier = Modifier) {
    SectionPlaceholderScreen(title = "Экран Меню", modifier = modifier)
}

@Composable
private fun SectionPlaceholderScreen(title: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundBlack),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF070708)
@Composable
private fun SearchScreenPreview() {
    TruckMarketTheme {
        SearchScreen()
    }
}
