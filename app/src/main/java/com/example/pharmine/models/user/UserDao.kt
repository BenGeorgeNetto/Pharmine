package com.example.pharmine.models.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    fun signUp(user: User)

    @Query("SELECT * FROM users WHERE user_name = :name")
    fun getUserByName(name: String): List<User>

    @Query("SELECT * FROM users WHERE user_phone = :phone")
    fun getUser(phone: Long): List<User>

    @Query("SELECT * FROM users WHERE user_email = :email")
    fun getUser(email: String): List<User>

    @Query("SELECT * FROM users WHERE logged_in = :b")
    fun getLoggedIn(b: Boolean = true): List<User>

    @Query("DELETE FROM users WHERE user_email = :email")
    fun deleteUser(email: String)

}