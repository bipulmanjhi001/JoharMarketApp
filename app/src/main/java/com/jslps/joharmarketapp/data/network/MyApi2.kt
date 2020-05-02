package com.sonu.mvvmsampleapp.data.network

import com.google.gson.GsonBuilder
import com.jslps.joharmarketapp.data.network.response.DistrictResponse
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


interface MyApi2 {

    @FormUrlEncoded
    @POST(AppConstant.getjharkhaddata) //end point value of base url here is getjharkhaddata as end point name
    suspend fun getDistrict(
        @Field("whr") whr:String,
        @Field("flag") flag:String,
        @Field("whr1") whr1:String,
        @Field("whr2") whr2:String
    ):Response<DistrictResponse>


    companion object{
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ):MyApi2{
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
                .baseUrl(AppConstant.domain2)
                .addConverterFactory(MyJsonConverter.create())
                .build()
                .create(MyApi2::class.java)
        }
    }
}