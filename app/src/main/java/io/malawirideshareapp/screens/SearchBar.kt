package io.malawirideshareapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchBar() {
    Row(horizontalArrangement = Arrangement.SpaceBetween,  modifier = Modifier.fillMaxWidth() ) {
        OutlinedTextField(value = "testing", onValueChange = {  }

        )
        Button( shape = CutCornerShape(8) ,onClick = { /*TODO*/ },) {
            Text("Search")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview () {
    SearchBar()
}