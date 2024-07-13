package io.malawirideshareapp.bottomNavigatonBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val selectedIcon: ImageVector, val unSelectedIcon: ImageVector,val  hasNews: Boolean, val badgeCount: Int? = null) {
    data object Home : Screen("home", "Home",  selectedIcon = Icons.Filled.Home,
        unSelectedIcon =  Icons.Outlined.Home,
        hasNews = false,)
    data object Activity : Screen("activity", "Activity",selectedIcon = Icons.AutoMirrored.Filled.List,
        unSelectedIcon =  Icons.AutoMirrored.Outlined.List, hasNews = false)
    data object Account : Screen("account", "Account",   selectedIcon = Icons.Filled.AccountBox,
        unSelectedIcon =  Icons.Outlined.AccountBox,
        hasNews = false,)
}