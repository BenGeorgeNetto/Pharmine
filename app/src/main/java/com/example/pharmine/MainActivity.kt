@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pharmine


import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pharmine.screens.HomeScreen
import com.example.pharmine.screens.Login
import com.example.pharmine.screens.Signup
import com.example.pharmine.screens.SplashScreen
import com.example.pharmine.ui.theme.PharmineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PharmineTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PharmineApp()
                }
            }
        }
    }
}

@Composable
fun PharmineApp() {
    val navController = rememberNavController()
    Navigation(navController = navController)
}

// routes for app
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.SplashScreen.route) {
        composable(NavigationItem.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(NavigationItem.Login.route) {
            Login()
        }
        composable(NavigationItem.Home.route) {
            HomeScreen(navController)
        }
        composable(NavigationItem.Signup.route) {
            Signup()
        }
    }

}

@Preview(name = "Light", showSystemUi = true)
@Preview(name = "Dark", showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    PharmineTheme {
        PharmineApp()
    }
}