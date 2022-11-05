package com.example.pharmine.screens

import android.app.Application
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pharmine.models.medicine.MedViewModel
import com.example.pharmine.models.medicine.Medicine


@Composable
fun PharmineApp(medViewModel: MedViewModel = viewModel()) {
    val allMedicine by medViewModel.allMedicine.observeAsState(listOf())
    val searchResults by medViewModel.searchResults.observeAsState(listOf())

    MainScreen(allMedicine, searchResults, medViewModel)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(allMedicine: List<Medicine>, searchResults: List<Medicine>, medViewModel: MedViewModel) {
    var medName by remember { mutableStateOf("") }
    var medAmt by remember {
        mutableStateOf("0")
    }
    val onMedTextChange = {text: String -> medName = text}
    val onMedAmtChange = {text: String -> medAmt = text}

    Column() {
        OutlinedTextField(value = medName, onValueChange = onMedTextChange)
        OutlinedTextField(value = medAmt, onValueChange = onMedAmtChange)
        Button(onClick ={
            val medicine = Medicine(medName, medAmt.toInt(), "")
            medViewModel.insertMedicine(medicine)
        }) {
            Text("Add")
        }
        LazyColumn(modifier = Modifier, content = {items(allMedicine) { MedItem(medicine = it)} })
    }
}

@Composable
fun MedItem(medicine: Medicine) {
    Card() {
        Row() {
            Text(text = medicine.medName)
            Spacer(modifier = Modifier.fillMaxWidth(0.5f))
            Text(text = medicine.medAmt.toString())
        }
    }
}

class MedViewModelFactory(val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MedViewModel(application) as T
    }
}