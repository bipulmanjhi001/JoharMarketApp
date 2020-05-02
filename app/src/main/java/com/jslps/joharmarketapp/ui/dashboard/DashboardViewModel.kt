package com.jslps.joharmarketapp.ui.dashboard

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jslps.joharmarketapp.R
import com.jslps.joharmarketapp.data.model.SeedDataDashboardModel
import com.jslps.joharmarketapp.data.repository.DashboardRepository
import com.sonu.mvvmsampleapp.util.Coroutines

class DashboardViewModel(
  private  val repository: DashboardRepository
): ViewModel() {

    var dashboardlistner: Dashboardlistner?=null


    fun onClicklogout(view: View){
        dashboardlistner?.logout()
    }

    fun deleteUser(){
        Coroutines.main{
            repository.deleteUser()
            dashboardlistner?.loggedout()
        }

    }


  //data for recylerview
    private val _data = MutableLiveData<List<SeedDataDashboardModel>>()
    val data: LiveData<List<SeedDataDashboardModel>>
        get() = _data

    fun getSeedData(){
        _data.value =repository.getSeedData()
    }


}