package com.example.pharmine.models.appointments

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [(Appointment::class)], version = 1)
abstract class AppointmentRoomDatabase: RoomDatabase() {

    abstract fun appointmentDao(): AppointmentDao

    companion object {
        private var INSTANCE: AppointmentRoomDatabase? = null

        fun getInstance(context: Context): AppointmentRoomDatabase {
            synchronized(this) {
                var instance = AppointmentRoomDatabase.INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppointmentRoomDatabase::class.java,
                        "appointment_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    AppointmentRoomDatabase.INSTANCE = instance
                }
                return instance
            }
        }
    }
}