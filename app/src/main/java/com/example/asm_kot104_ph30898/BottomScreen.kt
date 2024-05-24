package com.example.asm_kot104_ph30898

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomScreen(val route: String, val title: String, val icon: ImageVector) {
    object Home: BottomScreen(route = "home", title = "Home", icon = Icons.Default.Home)
    object Cart: BottomScreen(route = "cart", title = "Cart", icon = Icons.Default.ShoppingCart)
    object Notifitical: BottomScreen(route = "notifitical", title = "Notifitical", icon = Icons.Default.Notifications)
    object Profile: BottomScreen(route = "profile", title = "Profile", icon = Icons.Default.AccountBox)
}