@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.pharmine.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pharmine.R
import com.example.pharmine.ui.theme.PastelBlue
import com.example.pharmine.ui.theme.PharmineTheme
import com.example.pharmine.ui.theme.poppinsFamily

@Composable
fun Signup() {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(
                rememberScrollState()
            )
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Sign Up",
                fontFamily = poppinsFamily,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Name",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            InputName()
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Age",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            InputAge()
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Phone",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            InputPhone()
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Email ID",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            InputMail()
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Password",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            InputPassword()
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Emergency Contact Name",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            InputEmergencyContactName()
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Emergency Contact Phone",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            InputEmergencyContactNumber()
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Address",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            InputAddress()
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SignupButton()
                CancelButton()
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
//@Preview(showSystemUi = true, name = "SignInLight")
//@Composable
//fun SigninPreviewLight() {
//    PharmineTheme {
//        SignIn()
//    }
//}

@Composable
fun SignupButton() {
    TextButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = PastelBlue,
            contentColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Text(
            text = "Sign up",
            fontFamily = poppinsFamily,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 24.dp)
        )
    }
}


@Composable
fun CancelButton() {
    TextButton(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onBackground,
            contentColor = MaterialTheme.colorScheme.background
        )
    ) {
        Text(
            text = "Cancel",
            fontFamily = poppinsFamily,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 24.dp)
        )
    }
}

@Composable
fun InputPhone() {
    var username by remember {
        mutableStateOf("")
    }
    TextField(
        value = username,
        onValueChange = { username = it },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.inversePrimary,
            containerColor = MaterialTheme.colorScheme.tertiary,
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth(),
        label = {},
        singleLine = true
    )
}

@Composable
fun InputName() {
    var name by remember {
        mutableStateOf("")
    }
    TextField(
        value = name,
        onValueChange = { name = it },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.inversePrimary,
            containerColor = MaterialTheme.colorScheme.tertiary,
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth(),
        label = {},
        singleLine = true
    )
}

@Composable
fun InputAge() {
    var age by remember {
        mutableStateOf("")
    }
    TextField(
        value = age,
        onValueChange = { age = it },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.inversePrimary,
            containerColor = MaterialTheme.colorScheme.tertiary,
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth(),
        label = {},
        singleLine = true
    )
}

@Composable
fun InputMail() {
    var mail by remember {
        mutableStateOf("")
    }
    TextField(
        value = mail,
        onValueChange = { mail = it },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.inversePrimary,
            containerColor = MaterialTheme.colorScheme.tertiary,
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth(),
        label = {},
        singleLine = true
    )
}

@Composable
fun InputEmergencyContactName() {
    var emergencyContactName by remember {
        mutableStateOf("")
    }
    TextField(
        value = emergencyContactName,
        onValueChange = { emergencyContactName = it },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.inversePrimary,
            containerColor = MaterialTheme.colorScheme.tertiary,
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth(),
        label = {},
        singleLine = true
    )
}

@Composable
fun InputEmergencyContactNumber() {
    var emergencyContactNumber by remember {
        mutableStateOf("")
    }
    TextField(
        value = emergencyContactNumber,
        onValueChange = { emergencyContactNumber = it },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.inversePrimary,
            containerColor = MaterialTheme.colorScheme.tertiary,
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth(),
        label = {},
        singleLine = true
    )
}

@Composable
fun InputAddress() {
    var address by remember {
        mutableStateOf("")
    }
    TextField(
        value = address,
        onValueChange = { address = it },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.inversePrimary,
            containerColor = MaterialTheme.colorScheme.tertiary,
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth(),
        label = {},
        singleLine = false
    )
}

@Composable
fun InputPassword() {
    var password by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = { password = it },
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.inversePrimary,
            containerColor = MaterialTheme.colorScheme.tertiary,
        ),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (passwordVisible)
                R.drawable.ic_baseline_visibility_24
            else R.drawable.ic_baseline_visibility_off_24
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon( painter = painterResource(id = image) , contentDescription = null, tint = MaterialTheme.colorScheme.inversePrimary)
            }
        },
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth(),
        label = { },
        singleLine = true
    )
}

@Preview(showSystemUi = true, name = "SignInDark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SignupPreviewDark() {
    PharmineTheme {
        Signup()
    }
}