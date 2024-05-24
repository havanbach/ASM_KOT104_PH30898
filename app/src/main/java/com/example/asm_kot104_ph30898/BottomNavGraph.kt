package com.example.asm_kot104_ph30898

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.asm_kot104_ph30898.screens.Cart
import com.example.asm_kot104_ph30898.screens.Home
import com.example.asm_kot104_ph30898.screens.Notification
import com.example.asm_kot104_ph30898.screens.Profile

@Composable
fun BottomNavGraph(navController: NavController) {
    NavHost(navController = navController as NavHostController,
            startDestination = BottomScreen.Home.route
        ){
        composable(route = BottomScreen.Home.route){
            Home()
        }
        composable(route = BottomScreen.Cart.route){
            Cart()
        }
        composable(route = BottomScreen.Notifitical.route){
            Notification()
        }
        composable(route = BottomScreen.Profile.route){
            Profile()
        }
    }
}