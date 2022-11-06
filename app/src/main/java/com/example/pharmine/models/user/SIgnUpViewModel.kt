package com.example.pharmine.models.user

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SIgnUpViewModel(application: Application): ViewModel() {
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

    fun signUp(name:String, age: Int, number: Long, email: String, password: String, address: String): Boolean {
        repository.getUserByNumber(number)
        if(resultOfUser.value.isNullOrEmpty())
        {
            val newUser = User(name, age, number, email, address, password)
            repository.signUp(newUser)
            return true
        }
        return false
    }
}