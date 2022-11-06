package com.example.pharmine

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem (var route: String, var icon: ImageVector? = null, var title: String) {
    object Login: NavigationItem(route = "login", title = "Login")
    object Home: NavigationItem(route = "home", icon = Icons.Outlined.Home, title = "Home")
    object Signup: NavigationItem(route = "signup", title = "Signup")

}