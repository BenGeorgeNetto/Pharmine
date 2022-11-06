package com.example.pharmine.models.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class UserRepository(private val userDao: UserDao) {

    val currentUser = MutableLiveData<User?>()
    val searchResults = MutableLiveData<List<User>?>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun signUp(newUser: User) {
        coroutineScope.launch(Dispatchers.IO) {
            userDao.signUp(newUser)
            currentUser.value = newUser
        }
    }

    fun signIn() {
        coroutineScope.launch(Dispatchers.IO) {
            currentUser.value = searchResults.value?.get(0)
        }
    }

    fun getUser(email: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(email).await()
        }
    }

    fun getUserByName(user_name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFindByUser(user_name).await()
        }
    }

    fun getUserByNumber(number: Long) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(number).await()
        }
    }

    fun getUser() {
        coroutineScope.launch(Dispatchers.IO) {
            currentUser.value = null
        }
    }

    private fun asyncFindByUser(user_name: String): Deferred<List<User>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async userDao.getUserByName(user_name)
        }

    private fun asyncFind(number: Long): Deferred<List<User>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async userDao.getUser(number)
        }

        //email, address change
    private fun asyncFind(email: String): Deferred<List<User>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async userDao.getUser(email)
        }
}
