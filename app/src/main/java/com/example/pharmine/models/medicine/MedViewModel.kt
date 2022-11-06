package com.example.pharmine.models.medicine

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MedViewModel(application: Application): ViewModel() {

    val allMedicine: LiveData<List<Medicine>>
    private val repository: MedicineRepository
    val searchResults: MutableLiveData<List<Medicine>>

    init {
        val medicineDb = MedicineRoomDatabase.getInstance(application)
        val medicineDao = medicineDb.medicineDao()
        repository = MedicineRepository(medicineDao)
        allMedicine = repository.allMeds
        searchResults = repository.searchResults
    }

    fun insertMedicine(medicine: Medicine) {
        repository.insertMed(medicine)
    }

    fun findMedicine(name: String) {
        repository.findMed(name)
    }

    fun deleteMedicine(name: String) {
        repository.deleteMed(name)
    }

    fun runOutMedicine() {
        repository.runOutMeds()
    }
}