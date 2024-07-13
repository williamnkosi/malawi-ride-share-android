package io.malawirideshareapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


data class Location(val street:String, val city:String)
var listOfLocations = listOf(Location("412 Herkimer", "Brooklyn, NY"), Location("422 Fulton", "Brooklyn, NY"),Location("422 Fulton", "Brooklyn, NY"))
@Composable
fun PreviousSearchItems() {
    Column() {
        listOfLocations.forEachIndexed { index, location -> PreviousSearchItem(location = location) }
      
    }
}

@Composable
fun PreviousSearchItem(location: Location) {
    Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth() ) {
        Icon(imageVector = Icons.Filled.LocationOn, contentDescription = "Past locations" )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = location.street)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = location.city, color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviousSearchItemsPreview() {
    PreviousSearchItems()
}
