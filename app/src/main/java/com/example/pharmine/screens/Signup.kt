@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.pharmine.screens

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.pharmine.NavigationItem
import com.example.pharmine.R
import com.example.pharmine.models.user.SIgnUpViewModel
import com.example.pharmine.ui.theme.PastelBlue
import com.example.pharmine.ui.theme.poppinsFamily

@Composable
fun Signup(navController: NavController) {
    var number by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    var age by remember {
        mutableStateOf("")
    }
    var mail by remember {
        mutableStateOf("")
    }
    var password by remember { mutableStateOf("") }
    var emergencyContactName by remember {
        mutableStateOf("")
    }
    var emergencyContactNumber by remember {
        mutableStateOf("")
    }
    var address by remember {
        mutableStateOf("")
    }
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
            InputName(name){ name = it }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Age",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            InputAge(age) { age = it }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Phone",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            InputPhone(number) { number = it }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Email ID",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            InputMail(mail) { mail = it }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Password",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            InputPassword(password) { password = it }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Emergency Contact Name",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            InputEmergencyContactName(emergencyContactName) { emergencyContactName = it }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Emergency Contact Phone",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            InputEmergencyContactNumber(emergencyContactNumber) { emergencyContactNumber = it }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Address",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            InputAddress(address) { address = it }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SignupButton(name, age.toInt(), number.toLong(), mail, password, address, emergencyContactName, emergencyContactNumber.toLong())
                CancelButton(navController)
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
fun SignupButton(name: String, age: Int, number: Long, email: String, password: String, address: String, emergencyCoName: String, emergencyCoNumber: Long) {
    val signUpViewModel: SIgnUpViewModel = viewModel()
    TextButton(
        onClick = { signUpViewModel.signUp(name, age, number, email, password, address, emergencyCoName, emergencyCoNumber) },
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
fun CancelButton(navController: NavController) {
    TextButton(
        onClick = { navController.navigate(NavigationItem.Login.route) },
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
fun InputPhone(number: String, onValNumber: (String) -> Unit) {

    TextField(
        value = number,
        onValueChange = onValNumber,
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
fun InputName(name: String, onValName: (String) -> Unit) {
    TextField(
        value = name,
        onValueChange = onValName,
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
fun InputAge(age: String, onValAge: (String) -> Unit) {
    TextField(
        value = age,
        onValueChange = onValAge,
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
fun InputMail(mail: String, onValMail: (String) -> Unit) {
    TextField(
        value = mail,
        onValueChange = onValMail,
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
fun InputEmergencyContactName(emergencyContactName: String, onValECN: (String) -> Unit) {
    TextField(
        value = emergencyContactName,
        onValueChange = onValECN,
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
fun InputEmergencyContactNumber(emergencyContactNumber: String, onValECNum: (String) -> Unit) {
    TextField(
        value = emergencyContactNumber,
        onValueChange = onValECNum,
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
fun InputAddress(address: String, onValAddress: (String) -> Unit) {
    TextField(
        value = address,
        onValueChange = onValAddress,
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
fun InputPassword(password: String, onValPass: (String) -> Unit) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = password,
        onValueChange = onValPass,
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

//@Preview(showSystemUi = true, name = "SignInDark", uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun SignupPreviewDark() {
//    PharmineTheme {
//        Signup()
//    }
//}