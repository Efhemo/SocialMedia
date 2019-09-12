package com.efhem.socialmedia.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application) : AndroidViewModel(application) {

    private val userId = "-LmKkNDAh60zMZt1GrI4"

    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)


    private fun userHistory() {
        viewModelScope.launch {
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    /**
     * Factory for constructing LoginViewModel with parameter
     */
    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ProfileViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}
