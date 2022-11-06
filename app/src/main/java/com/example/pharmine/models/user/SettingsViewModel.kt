package com.example.pharmine.models.user

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel(application: Application): ViewModel() {
    val currentUser: MutableLiveData<User?>
    private val repository:UserRepository

    init {
        val userDb = UserRoomDatabase.getInstance(application)
        val userDao = userDb.userDao()
        repository = UserRepository(userDao)
        currentUser = repository.currentUser
    }
}