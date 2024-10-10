package com.daemon.home.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: BottomNavItem(route = "home", title = "Home", icon = Icons.Outlined.Home)
    object Product: BottomNavItem(route = "product", title = "Product", icon = Icons.Outlined.ShoppingCart)
    object Order: BottomNavItem(route = "order", title = "Order", icon = Icons.Outlined.List)
    object Account: BottomNavItem(route = "account", title = "Account", icon = Icons.Outlined.Person)
}