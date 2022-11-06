package com.example.pharmine.models.appointments

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppointmentDao {

    @Insert
    fun insertAppointment(appointment: Appointment)

    @Query("SELECT * FROM appointments WHERE apt_id = :id")
    fun findApts(id: Int): List<Appointment>

    @Query("DELETE FROM appointments WHERE apt_id = :id")
    fun deleteApts(id: Int)

    @Query("SELECT * FROM appointments")
    fun getAllApts(): LiveData<List<Appointment>>
}