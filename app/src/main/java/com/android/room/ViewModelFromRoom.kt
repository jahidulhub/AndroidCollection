package com.android.room

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModelFromRoom(application: Application) : ViewModel() {
    private val database: AppDatabase = AppDatabase.getInstance(application)
    internal val users: LiveData<MutableList<User>> = database.userDao().getAll()

    fun insert(user: User) {
        viewModelScope.launch {
            database.userDao().insertAll(user)
        }
    }
}