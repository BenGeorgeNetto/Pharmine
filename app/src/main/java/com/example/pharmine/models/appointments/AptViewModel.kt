package com.example.pharmine.models.appointments

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AptViewModel(application: Application): ViewModel() {

    val allAppointment: LiveData<List<Appointment>>
    private val repository: AppointmentRepository
    val searchResults: MutableLiveData<List<Appointment>>

    init {
        val appointmentDb = AppointmentRoomDatabase.getInstance(application)
        val appointmentDao = appointmentDb.appointmentDao()
        repository = AppointmentRepository(appointmentDao)
        allAppointment = repository.allApts
        searchResults = repository.searchResults
    }

    fun insertAppointment(appointment: Appointment) {
        repository.insertApts(appointment)
    }

    fun findApppointments(id: Int) {
        repository.findApt(id = id)
    }

    fun deleteAmt(id: Int) {
        repository.deleteApt(id)
    }
}