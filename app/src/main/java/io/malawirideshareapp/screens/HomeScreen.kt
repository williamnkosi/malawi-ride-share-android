package io.malawirideshareapp.screens


import android.Manifest
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button

import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.malawirideshareapp.composables.AccessFineLocationPermissionTextProvider
import io.malawirideshareapp.composables.PermissionDialog
import io.malawirideshareapp.composables.PermissionTextProvider


@Composable
fun HomeScreen() {
    val viewModel = viewModel<HomeViewModel>()
    val dialogQueue = viewModel.visiblePermissionDialog

    val userLocationPermissionResultLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            Log.i("test", isGranted.toString())
            viewModel.onPermissionResult( permission = Manifest.permission.ACCESS_FINE_LOCATION, isGranted = isGranted)

        }
    )
    LaunchedEffect(key1 = true) {
        userLocationPermissionResultLauncher .launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
            , modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            SearchBar()
            Spacer(modifier = Modifier.height(8.dp))
            PreviousSearchItems()
            Button(onClick = {

           }) {
                Text(text = "Testing")

            }
        }

        dialogQueue.forEach { permission ->
            PermissionDialog(
                permissionTextProvider = AccessFineLocationPermissionTextProvider(),
                isPermanentlyDeclined = permission.isPermanentlyDeclined,
                onDismiss = { viewModel.onDismissPermissionDialog(permission) },
                onOkClick = { viewModel.onPermissionResult(permission.permission, true) },
                onGoToAppSettingsClick = { viewModel.onGoToAppSettingsClick() }
            )
        }
    }
}



@Preview
@Composable
    fun HomeScreenPreview() {
    HomeScreen()
}

