package com.example.pharmine.models.appointments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class AppointmentRepository(private val appointmentDao: AppointmentDao) {
    val allApts: LiveData<List<Appointment>> = appointmentDao.getAllApts()
    val searchResults = MutableLiveData<List<Appointment>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertApts(newApts: Appointment) {
        coroutineScope.launch(Dispatchers.IO) {
            appointmentDao.insertAppointment(newApts)
        }
    }

    fun deleteApt(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            appointmentDao.deleteApts(id)
        }
    }

    fun findApt(id: Int) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(id).await()
        }
    }

    private fun asyncFind(id: Int): Deferred<List<Appointment>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async appointmentDao.findApts(id)
        }
}