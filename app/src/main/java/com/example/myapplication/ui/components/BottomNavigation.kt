package com.example.myapplication.ui.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.myapplication.data.model.ItemsBottomNav
import com.example.myapplication.navigation.currentRoute

@Composable
fun BottomNavigation(navHostController: NavHostController){
    val menuItems = listOf(
        ItemsBottomNav.ItemNavigationAddGame,
        ItemsBottomNav.ItemNavigationHome,
        ItemsBottomNav.ItemNavigationViewGames
    )
    BottomAppBar {
        NavigationBar {
            menuItems.forEach { item ->
                val isSelected = currentRoute(navController = navHostController) == item.route
                NavigationBarItem(selected = isSelected,
                    onClick = { navHostController.navigate(item.route) },
                    icon = {
                        Icon(imageVector = item.icon,
                            contentDescription = item.title)
                    },
                    label = { Text(text = item.title)})
            }
        }
    }
}
