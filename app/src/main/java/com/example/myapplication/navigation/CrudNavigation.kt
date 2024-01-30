package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.data.model.NavScreen
import com.example.myapplication.ui.screens.AddGame
import com.example.myapplication.ui.screens.EditGame
import com.example.myapplication.ui.screens.Home
import com.example.myapplication.ui.screens.ViewGame

@Composable
fun CrudNavigation(navHostController: NavHostController){
    NavHost(navController = navHostController,
        startDestination = NavScreen.Home.name){

        composable(NavScreen.Home.name){
            Home()
        }

        composable(NavScreen.ViewGames.name){
            ViewGame()
        }

        composable(NavScreen.AddGame.name){
            AddGame()
        }
    }
}