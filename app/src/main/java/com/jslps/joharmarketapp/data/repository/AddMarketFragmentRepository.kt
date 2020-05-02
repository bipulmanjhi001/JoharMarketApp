package com.jslps.joharmarketapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jslps.joharmarketapp.data.db.AppDatabase
import com.jslps.joharmarketapp.data.db.User
import com.jslps.joharmarketapp.data.network.response.DistrictResponse
import com.jslps.joharmarketapp.data.network.response.LoginResponse
import com.jslps.joharmarketapp.data.network.response.LoginResponseNew
import com.jslps.joharmarketapp.util.AppConstant
import com.sonu.mvvmsampleapp.data.network.MyApi
import com.sonu.mvvmsampleapp.data.network.MyApi2
import com.sonu.mvvmsampleapp.data.network.SafeApiRequest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddMarketFragmentRepository(
    private val api: MyApi2,
    private val db: AppDatabase
) : SafeApiRequest() {
    suspend fun getDistrict(flag:String) :DistrictResponse{
       return apiRequest{api.getDistrict("",flag,"","")}
    }
}