package com.example.pharmine.models.medicine

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(Medicine::class)], version = 1)
abstract class MedicineRoomDatabase: RoomDatabase() {

    abstract fun medicineDao(): MedicineDao

    companion object {
        private var INSTANCE: MedicineRoomDatabase? = null

        fun getInstance(context: Context): MedicineRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MedicineRoomDatabase::class.java,
                        "medicine_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}