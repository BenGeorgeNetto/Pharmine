package com.example.pharmine.models.medicine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class MedicineRepository(private val medicineDao: MedicineDao) {
    val allMeds: LiveData<List<Medicine>> = medicineDao.getAllMeds()
    val searchResults = MutableLiveData<List<Medicine>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertMed(newMedicine: Medicine) {
        coroutineScope.launch(Dispatchers.IO) {
            medicineDao.InsertMed(newMedicine)
        }
    }

    fun deleteMed(name: String) {
        coroutineScope.launch(Dispatchers.IO) {
            medicineDao.deleteMeds(name)
        }
    }

    fun findMed(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }

    private fun asyncFind(name: String): Deferred<List<Medicine>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async medicineDao.findMeds(name)
        }

    private fun asyncFind(): Deferred<List<Medicine>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async medicineDao.runOutMeds()
        }

    fun runOutMeds() {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind().await()
        }
    }
}