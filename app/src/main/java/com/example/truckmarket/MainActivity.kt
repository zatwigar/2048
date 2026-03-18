package com.example.truckmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.truckmarket.ui.navigation.TruckMarketApp
import com.example.truckmarket.ui.theme.TruckMarketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TruckMarketTheme {
                TruckMarketApp()
            }
        }
    }
}
