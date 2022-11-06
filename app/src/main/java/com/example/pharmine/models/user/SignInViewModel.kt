package com.example.pharmine.models.user

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignInViewModel(application: Application): ViewModel() {
    val currentUser: MutableLiveData<User?>
    private val repository:UserRepository
    val resultOfUser: MutableLiveData<List<User>?>

    init {
        val userDb = UserRoomDatabase.getInstance(application)
        val userDao = userDb.userDao()
        repository = UserRepository(userDao)
        currentUser = repository.currentUser
        resultOfUser = repository.searchResults
    }

    fun signIn(number: Long, password: String): Boolean {
        repository.getUserByNumber(number)
        if(resultOfUser.value.isNullOrEmpty() || !(resultOfUser.value!![0].userPass.equals(password)))
        {
            return false
        }
        repository.signIn()
        return true
    }
}