package com.jslps.joharmarketapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jslps.joharmarketapp.data.db.AppDatabase
import com.jslps.joharmarketapp.data.db.User
import com.jslps.joharmarketapp.data.network.response.LoginResponse
import com.jslps.joharmarketapp.data.seeddata.DashboardSeedData
import com.sonu.mvvmsampleapp.data.network.MyApi
import com.sonu.mvvmsampleapp.data.network.SafeApiRequest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DashboardRepository(
    private val db: AppDatabase,
    private val seedData: DashboardSeedData
)
{
    // fun getUser() = db.getDashboardDao().getUser()
    suspend fun deleteUser() = db.getDashboardDao().deleteUser()
    fun getSeedData() = seedData.getListData()

}