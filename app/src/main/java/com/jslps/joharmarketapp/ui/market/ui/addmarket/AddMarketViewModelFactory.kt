package com.jslps.joharmarketapp.ui.market.ui.addmarket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jslps.joharmarketapp.data.repository.AddMarketFragmentRepository
import com.jslps.joharmarketapp.data.repository.DashboardRepository
import com.jslps.joharmarketapp.data.repository.UserRepository

@Suppress("UNCHECKED_CAST")
class AddMarketViewModelFactory(
    private val repository: AddMarketFragmentRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddMarketViewModel(repository) as T
    }
}