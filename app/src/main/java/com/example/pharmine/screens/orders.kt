package com.example.pharmine.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pharmine.ui.theme.PastelBlue
import com.example.pharmine.ui.theme.PastelYellow

@Composable
fun Orders() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // top bar

        // search
        SearchBar()

        Spacer(modifier = Modifier.height(24.dp))
        // go to cart button
        OrderButton()

        Spacer(modifier = Modifier.height(36.dp))
        // cart items
        OrderInformation(medicineName = "Calpol", arrivalTime = "12:00PM Today")
        OrderInformation(medicineName = "Ibuprofen", arrivalTime = "6:00PM Friday")
        OrderInformation(medicineName = "Clopilet", arrivalTime = "8:00PM Friday")

        // bottom nav bar
    }
}

@Composable
fun OrderInformation(medicineName: String, arrivalTime: String) {
    Card(
        elevation = CardDefaults.cardElevation(16.dp),
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .wrapContentHeight(),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, Color.Gray),
        colors = CardDefaults.cardColors(containerColor = PastelYellow)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(.6f)
            ) {
                Text(text = medicineName)
            }
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(.4f)
            ) {
                Text(text = "Arriving on")
                Text(text = arrivalTime)
            }
        }
    }
}

@Composable
fun OrderButton() {
    TextButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = PastelBlue),

        modifier = Modifier.size(300.dp, 64.dp)
    ) {
        Text(text = "Go to cart")
    }
}


@Preview(name = "Light", showSystemUi = true)
@Composable
fun D2Preview() {
    Orders()
}