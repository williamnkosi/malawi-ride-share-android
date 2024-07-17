package io.malawirideshareapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import io.malawirideshareapp.ui.theme.MalawiRideShareAppTheme
import com.amplifyframework.ui.authenticator.ui.Authenticator
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import io.malawirideshareapp.bottomNavigatonBar.BottomNavGraph
import io.malawirideshareapp.bottomNavigatonBar.BottomNavigationBar


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MalawiRideShareAppTheme {

                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                    Authenticator { state ->
                        Scaffold(
                            bottomBar = {BottomNavigationBar(navController)}
                        ){ padding ->
                            Column(
                                modifier = Modifier.padding(padding)
                            ){
                                BottomNavGraph(navController = navController)
                            }

                        }
//
                    }
                }
            }
        }
    }
}

