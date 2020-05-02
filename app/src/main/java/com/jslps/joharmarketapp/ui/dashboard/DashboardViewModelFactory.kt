package com.jslps.joharmarketapp.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jslps.joharmarketapp.data.repository.DashboardRepository
import com.jslps.joharmarketapp.data.repository.UserRepository

@Suppress("UNCHECKED_CAST")
class DashboardViewModelFactory(
    private val repository: DashboardRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DashboardViewModel(repository) as T
    }
}