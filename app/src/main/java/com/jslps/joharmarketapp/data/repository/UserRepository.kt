package com.jslps.joharmarketapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jslps.joharmarketapp.data.db.AppDatabase
import com.jslps.joharmarketapp.data.db.User
import com.jslps.joharmarketapp.data.network.response.LoginResponse
import com.jslps.joharmarketapp.data.network.response.LoginResponseNew
import com.sonu.mvvmsampleapp.data.network.MyApi
import com.sonu.mvvmsampleapp.data.network.SafeApiRequest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
   ) : SafeApiRequest() {
    suspend fun userLogin(email:String,password:String) :LoginResponseNew{
       return apiRequest{api.userLogin(email,password)}
    }
    suspend fun saveUser(user: User): Long  {
        val value =db.getUserDao().addUser(user)
        return value
    }
     //= can be used in place of bracket in kotlin

     fun getUser() = db.getUserDao().getUser()



}