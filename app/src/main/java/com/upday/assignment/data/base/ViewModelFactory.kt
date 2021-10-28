package com.upday.assignment.data.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.upday.assignment.data.api.ApiHelper
import com.upday.assignment.data.repository.MainRepository
import com.upday.assignment.ui.main.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(MainRepository(apiHelper)) as T
            }
            else -> throw IllegalArgumentException("Unknown class name")
        }
    }
}