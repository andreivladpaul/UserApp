package com.hfad.datianagrafici.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.hfad.datianagrafici.data.User
import com.hfad.datianagrafici.databse.UserDatabase
import com.hfad.datianagrafici.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application) {
    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User){
        //lancia l'applicazione in un thread in background
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }
}