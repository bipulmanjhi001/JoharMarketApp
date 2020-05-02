package com.sonu.mvvmsampleapp.data.network

import com.google.gson.GsonBuilder
import com.jslps.joharmarketapp.data.network.response.LoginResponseNew
import com.jslps.joharmarketapp.util.AppConstant
import com.jslps.joharmarketapp.util.MyJsonConverter
import net.simplifiedcoding.mvvmsampleapp.data.network.NetworkConnectionInterceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.concurrent.TimeUnit


interface MyApi {

    @FormUrlEncoded
    @POST(AppConstant.loginMethod) //end point value of base url here is login as end point name
    suspend fun userLogin(
        @Field("user") email:String,
        @Field("pass") password:String
    ):Response<LoginResponseNew>


    companion object{
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ):MyApi{
            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .readTimeout(2, TimeUnit.MINUTES)
                .connectTimeout(2, TimeUnit.MINUTES)
                .build()

//            val gson = GsonBuilder()
//                .setLenient()
//                .create()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl(AppConstant.domain)
                .addConverterFactory(MyJsonConverter.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}