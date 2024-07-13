package io.malawirideshareapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import io.malawirideshareapp.ui.theme.MalawiRideShareAppTheme
import com.amplifyframework.ui.authenticator.ui.Authenticator
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import com.amplifyframework.core.Amplify

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MalawiRideShareAppTheme {
                // A surface container using the 'background' color from the theme
                val items = listOf(
                    BottomNavigationItem(
                        title = "Home",
                        selectedIcon = Icons.Filled.Home,
                        unSelectedIcon =  Icons.Outlined.Home,
                        hasNews = false,
                    ),
                    BottomNavigationItem(
                        title = "Activity",
                        selectedIcon = Icons.AutoMirrored.Filled.List,
                        unSelectedIcon =  Icons.AutoMirrored.Outlined.List,
                        hasNews = false,
                    ),
                    BottomNavigationItem(
                        title = "Account",
                        selectedIcon = Icons.Filled.AccountBox,
                        unSelectedIcon =  Icons.Outlined.AccountBox,
                        hasNews = false,
                    )
                )

                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),

                    color = MaterialTheme.colorScheme.background
                )

                {
                    Authenticator { state ->
                        Scaffold(
                            bottomBar = {
                                NavigationBar {
                                    items.forEachIndexed{ index, item -> 
                                        NavigationBarItem(
                                            selected = selectedItemIndex == index,
                                            onClick = { selectedItemIndex = index},
                                            label = {
                                                Text(text = item.title)
                                            },
                                            icon = { BadgedBox(badge = {
                                                if(item.badgeCount != null){
                                                    Badge{
                                                        Text(text = item.badgeCount.toString())
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
                        ){}
//                        Column {
//                            Text(
//                                text = "Hello ${state.user.username}!",
//                            )
//                            Button(onClick = {
//                                Amplify.Auth.signOut {  }
//                            }) {
//                                Text(text = "Sign Out")
//                            }
//                        }
                    }
                }



            }
        }
    }
}

