package io.malawirideshareapp.screens

import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {
    val visiblePermissionDialog = mutableListOf<String>()

    fun dismissDialog(){
        visiblePermissionDialog.removeLast()
    }

    fun onPermissionResult(permission: String, isGranted: Boolean){
        if(!isGranted){
            visiblePermissionDialog.add(0, permission)
        }
    }
}