package io.malawirideshareapp.screens

import android.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    var text by remember { mutableStateOf("Hello") }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
            , modifier = Modifier.padding(16.dp).fillMaxSize()
        ) {

           SearchBar(text = text)
        }
    }
}

@Composable
fun SearchBar(text:String) {
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
    SearchBar(text = "testing")
}