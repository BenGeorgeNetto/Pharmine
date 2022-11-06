package com.example.pharmine.models.user

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User {

    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "user_phone")
    var userPhone: Long = 0

    @ColumnInfo(name = "user_name")
    var userName: String = ""

    @ColumnInfo(name = "user_age")
    var userAge: Int = 0

    @ColumnInfo(name = "user_email")
    var userEmail: String = ""

    @ColumnInfo(name = "user_address")
    var userAddress: String = ""

    @ColumnInfo(name = "user_pass")
    var userPass: String = ""

    @ColumnInfo(name = "logged_in")
    var logInState: Boolean = false

    constructor() {}

    constructor(name: String, age: Int, phone: Long, email: String = "", address: String = "", password: String = "") {
        this.userName = name
        this.userAge = age
        this.userEmail = email
        this.userPhone = phone
        this.userPass = password
    }

    fun update(email: String = userEmail, address: String = userAddress)
    {
        userEmail = email
        userAddress = address
    }
    fun onGetIn() {
        this.logInState = true
    }
    fun onGetOut() {
        this.logInState = false
    }
}