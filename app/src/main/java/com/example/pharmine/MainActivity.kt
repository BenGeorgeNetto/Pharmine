package com.example.pharmine

import android.app.Application
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pharmine.models.medicine.MedViewModel
import com.example.pharmine.screens.MedViewModelFactory
import com.example.pharmine.screens.PharmineApp
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

                    val owner = LocalViewModelStoreOwner.current

                    owner?.let {
                        val viewModel: MedViewModel = viewModel(
                            it,
                            "MainViewModel",
                            MedViewModelFactory(
                                LocalContext.current.applicationContext
                                        as Application
                            )
                        )

                        PharmineApp(viewModel)
                    }
                }
            }
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
