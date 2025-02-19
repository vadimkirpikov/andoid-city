package com.example.city

import MainViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.LocalCafe
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun NavigationMenu(
    navController: NavController,
    viewModel: MainViewModel,
    isRail: Boolean
) {
    val items = listOf(
        "Coffee shops" to Icons.Default.LocalCafe,
        "Fast food places" to Icons.Default.Fastfood,
        "Restaurants" to Icons.Default.Restaurant
    )

    if (isRail) {
        NavigationRail {
            items.forEach { (label, icon) ->
                NavigationRailItem(
                    icon = { Icon(icon, label) },
                    selected = false,
                    onClick = {
                        viewModel.selectCategory(label)
                        navController.navigate("places")
                    }
                )
            }
        }
    } else {
        NavigationBar {
            items.forEach { (label, icon) ->
                NavigationBarItem(
                    icon = { Icon(icon, label) },
                    selected = false,
                    onClick = {
                        viewModel.selectCategory(label)
                        navController.navigate("places")
                    }
                )
            }
        }
    }
}