package com.example.truckmarket.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.truckmarket.ui.theme.AccentOrange
import com.example.truckmarket.ui.theme.BackgroundBlack
import com.example.truckmarket.ui.theme.DividerDark
import com.example.truckmarket.ui.theme.SurfaceDark
import com.example.truckmarket.ui.theme.SurfaceDarkSecondary
import com.example.truckmarket.ui.theme.TextPrimary
import com.example.truckmarket.ui.theme.TextSecondary
import com.example.truckmarket.ui.theme.TruckMarketTheme

@Composable
fun TopHeader(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .clip(RoundedCornerShape(14.dp))
                    .background(SurfaceDark)
                    .size(46.dp),
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = "Назад",
                    tint = TextPrimary,
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(22.dp))
                    .background(AccentOrange)
                    .padding(horizontal = 18.dp, vertical = 14.dp),
            ) {
                Text(
                    text = "ZATWIGAR · TRUCK HUB",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))
        FilterPanel()
    }
}

@Composable
fun FilterPanel(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(28.dp))
            .background(SurfaceDark)
            .border(1.dp, DividerDark, RoundedCornerShape(28.dp)),
    ) {
        FilterItem(
            title = "Марка, модель, поколение",
            modifier = Modifier.fillMaxWidth(),
            roundedTop = true,
        )
        Row(Modifier.fillMaxWidth()) {
            FilterItem(title = "Год", modifier = Modifier.weight(1f), showRightDivider = true)
            FilterItem(title = "Цена", modifier = Modifier.weight(1f), showRightDivider = true)
            FilterItem(
                title = "Параметры",
                modifier = Modifier.weight(1.6f),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Tune,
                        contentDescription = null,
                        tint = TextPrimary,
                    )
                },
            )
        }
        FilterItem(
            title = "Все регионы",
            modifier = Modifier.fillMaxWidth(),
            roundedBottom = true,
        )
    }
}

@Composable
private fun FilterItem(
    title: String,
    modifier: Modifier = Modifier,
    roundedTop: Boolean = false,
    roundedBottom: Boolean = false,
    showRightDivider: Boolean = false,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    val shape = RoundedCornerShape(
        topStart = if (roundedTop) 28.dp else 0.dp,
        topEnd = if (roundedTop) 28.dp else 0.dp,
        bottomStart = if (roundedBottom) 28.dp else 0.dp,
        bottomEnd = if (roundedBottom) 28.dp else 0.dp,
    )
    Row(
        modifier = modifier
            .clip(shape)
            .background(SurfaceDarkSecondary)
            .border(
                width = 0.6.dp,
                color = DividerDark,
                shape = shape,
            )
            .padding(horizontal = 18.dp, vertical = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        leadingIcon?.invoke()
        Text(text = title, color = TextPrimary)
        if (showRightDivider) {
            Spacer(modifier = Modifier)
        }
    }
}

@Composable
fun StatsSwitcher(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(22.dp))
                .background(SurfaceDark)
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            StatChip(title = "0 объявлений", selected = true, modifier = Modifier.weight(1f))
            StatChip(title = "0 моделей", selected = false, modifier = Modifier.weight(1f))
        }

        Box(
            modifier = Modifier
                .size(54.dp)
                .clip(RoundedCornerShape(18.dp))
                .background(SurfaceDark),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Outlined.FilterList,
                contentDescription = "Фильтр",
                tint = TextPrimary,
            )
        }
    }
}

@Composable
private fun StatChip(title: String, selected: Boolean, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(if (selected) SurfaceDarkSecondary else BackgroundBlack.copy(alpha = 0.45f))
            .padding(vertical = 14.dp, horizontal = 12.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = title, color = TextPrimary)
    }
}

@Composable
fun EmptyStateCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .background(SurfaceDark)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(SurfaceDarkSecondary),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "Image placeholder",
                color = TextSecondary,
                textAlign = TextAlign.Center,
            )
        }

        Spacer(modifier = Modifier.height(28.dp))
        Text(
            text = "Похоже, все грузовики в рейсе.\nНо ваш может стать здесь первым!\nЖмите кнопку и выезжайте на витрину.",
            color = TextPrimary,
            textAlign = TextAlign.Center,
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF070708)
@Composable
private fun SearchComponentsPreview() {
    TruckMarketTheme {
        Column(
            modifier = Modifier
                .background(BackgroundBlack)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp),
        ) {
            TopHeader()
            StatsSwitcher()
            EmptyStateCard()
        }
    }
}
