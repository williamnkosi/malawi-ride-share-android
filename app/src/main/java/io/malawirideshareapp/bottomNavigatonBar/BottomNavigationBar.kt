package io.malawirideshareapp.bottomNavigatonBar

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.malawirideshareapp.screens.AccountScreen
import io.malawirideshareapp.screens.ActivityScreen
import io.malawirideshareapp.screens.HomeScreen
import androidx.compose.runtime.setValue



@Composable
fun BottomNavigationBar(navController: NavHostController){
    val items = listOf<Screen>(
        Screen.Home,
        Screen.Activity,
        Screen.Account
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    NavigationBar {

        items.forEachIndexed{ index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = { selectedItemIndex = index
                          },
                label = {
                    Text(text = item.title)
                },
                icon = { BadgedBox(badge = {
                    if(item.badgeCount != null){
                        Badge{
                            Text(text = item.badgeCount.toString())

                            navController.navigate(item.route)
                        }
                    } else if(item.hasNews){
                        Badge()
                    }
                }) {
                    Icon(imageVector = if(index == selectedItemIndex){ item.selectedIcon} else {item.unSelectedIcon}, contentDescription = item.title )
                } })
        }
    }
}

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen() }
        composable(Screen.Activity.route) { ActivityScreen() }
        composable(Screen.Account.route) { AccountScreen() }
    }
}