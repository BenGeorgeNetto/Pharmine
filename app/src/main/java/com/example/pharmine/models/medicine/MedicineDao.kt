package com.example.pharmine.models.medicine

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MedicineDao {

    @Insert
    fun InsertMed(medicine: Medicine)

    @Query("SELECT * FROM medicines WHERE med_name = :name")
    fun findMeds(name: String): List<Medicine>

    @Query("SELECT * FROM medicines WHERE med_amt < 4")
    fun runOutMeds(): List<Medicine>

    @Query("DELETE FROM medicines WHERE med_name = :name")
    fun deleteMeds(name: String)

    @Query("SELECT * FROM medicines")
    fun getAllMeds(): LiveData<List<Medicine>>
}