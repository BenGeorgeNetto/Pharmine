package com.example.pharmine.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pharmine.R
import com.example.pharmine.ui.theme.PastelYellow

@Composable
fun Appointments() {
    // top bar

    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // search bar
        SearchBar()

        // cards
        DoctorCard(
            name = "Dr. Jincy Abraham",
            specialization = "Orthopedica",
            location = "Govt. Medical College, Tvm",
            image = "",
            time = "11:00 AM, Thursday"
        )
        DoctorCard(
            name = "Dr. Anoop Menon",
            specialization = "Diebetology",
            location = "Govt. Medical College, Tvm",
            image = "",
            time = "03:00 PM, Sunday"
        )
    }

    // bottom navbar
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        var searchQuery by remember { mutableStateOf("") }
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text(text = "Search", fontSize = 12.sp) },
            shape = RoundedCornerShape(48.dp),
            modifier = Modifier.height(48.dp),
            singleLine = true,
//            colors = TextFieldDefaults.textFieldColors(containerColor = Color(0xFFD7DDE9))
            colors = TextFieldDefaults.textFieldColors(containerColor = LightGray),
//            colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.tertiary)
            trailingIcon = {IconButton(onClick = { /*TODO*/ }) {
                Icon( imageVector = Icons.Filled.Lock, contentDescription = null )
            }},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { /*TODO*/ }
            )
        )
    }
}

@Composable
fun DoctorCard(
    name: String,
    specialization: String,
    location: String,
    image: String,
    time: String
) {
    Card(
        elevation = CardDefaults.cardElevation(16.dp),
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .wrapContentHeight(),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, Color.Gray),
//         colors = CardDefaults.cardColors(containerColor = Color(0xFFFCEECB))
        colors = CardDefaults.cardColors(containerColor = PastelYellow)
//        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier
                .padding(4.dp)
                .weight(.7f)
            ) {
                Text(text = name, fontSize = 24.sp)
                Text(text = specialization, fontSize = 12.sp)
                Text(text = location, fontSize = 12.sp)
                Text(text = time, fontSize = 16.sp)
            }
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(.3f)
            ) {
                Image(
                    painterResource(id = R.drawable.doctor_2),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}

@Preview(name = "Light", showSystemUi = true)
@Composable
fun DPreview() {
    Appointments()
}