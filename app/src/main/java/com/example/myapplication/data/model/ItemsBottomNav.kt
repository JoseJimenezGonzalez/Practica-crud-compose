package com.example.myapplication.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Preview
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ItemsBottomNav(
    val icon: ImageVector,
    val title: String,
    val route: String
) {
    object ItemNavigationHome: ItemsBottomNav(
        Icons.Outlined.Home,
        "Home",
        NavScreen.Home.name
    )

    object ItemNavigationAddGame: ItemsBottomNav(
        Icons.Outlined.Add,
        "Añadir",
        NavScreen.AddGame.name
    )

    object ItemNavigationViewGames: ItemsBottomNav(
        Icons.Outlined.Preview,
        "Ver",
        NavScreen.ViewGames.name
    )
}