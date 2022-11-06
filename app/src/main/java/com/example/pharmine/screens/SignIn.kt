@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pharmine.screens

import android.app.Application
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavController
import com.example.pharmine.NavigationItem
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pharmine.R
import com.example.pharmine.models.user.SignInViewModel
import com.example.pharmine.ui.theme.PastelBlue
import com.example.pharmine.ui.theme.poppinsFamily

class SignInViewModelFactory(val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignInViewModel(application) as T
    }
}

@Composable
fun SignIn(navController: NavController){
    var username by remember {
        mutableStateOf("0")
    }
    var password by remember { mutableStateOf("") }
    var onVarPhone = {it: String-> username = it }
    var onVarPas = {it: String-> password = it}
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.pharmine_logo),
                contentDescription = "logo",
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp),
                colorFilter = ColorFilter.tint(PastelBlue)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Pharmine",
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
                text = "Phone number",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            EnterPhone(username, onVarPhone)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Password",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )
            EnterPassword(password, onVarPas)
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val owner = LocalViewModelStoreOwner.current

                owner?.let {
                    val signInViewModel: SignInViewModel = viewModel(
                        it,
                        "SignInViewModel",
                        SignInViewModelFactory(LocalContext.current.applicationContext as Application
                        )
                    )
                SignInButton(username, password, navController, signInViewModel)
                }
                SignUpButton(navController)
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
fun SignInButton(user: String, password: String, navController: NavController, signInViewModel: SignInViewModel) {
    TextButton(
        onClick = {
            signInViewModel.signIn(user, password)
            navController.navigate(NavigationItem.Home.route)
                  },
        colors = ButtonDefaults.buttonColors(
            containerColor = PastelBlue,
            contentColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Text(
            text = "Sign In",
            fontFamily = poppinsFamily,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 24.dp)
        )
    }
}


@Composable
fun SignUpButton(navController: NavController) {
    TextButton(
        onClick = { navController.navigate(NavigationItem.Signup.route) },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onBackground,
            contentColor = MaterialTheme.colorScheme.background
        )
    ) {
        Text(
            text = "Sign Up",
            fontFamily = poppinsFamily,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 24.dp)
        )
    }
}

@Composable
fun EnterPhone(phone: String, onValPhone: (String)-> Unit) {
    TextField(
        value = phone,
        onValueChange = onValPhone,
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colorScheme.inversePrimary,
            containerColor = MaterialTheme.colorScheme.tertiary,
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth(),
        label = { Text(
            text = "Enter your phone number",
            color = MaterialTheme.colorScheme.inversePrimary
        ) },
        singleLine = true
    )
}

@Composable
fun EnterPassword(password: String, onValPass: (String)-> Unit) {
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
        label = { Text(
            text = "Enter your password",
            color = MaterialTheme.colorScheme.inversePrimary
        ) },
        singleLine = true
    )
}

//@Preview(showSystemUi = true, name = "SignInDark", uiMode = UI_MODE_NIGHT_YES)
//@Composable
//fun SigninPreviewDark() {
//    PharmineTheme {
//        SignIn()
//    }
//}