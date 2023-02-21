package com.hfad.datianagrafici.repository

import androidx.lifecycle.LiveData
import com.hfad.datianagrafici.dao.UserDao
import com.hfad.datianagrafici.data.User

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}