package com.jslps.joharmarketapp.ui.login

import androidx.lifecycle.LiveData
import com.jslps.joharmarketapp.data.db.User
import com.jslps.joharmarketapp.data.network.response.Detail

interface LoginListner {
    fun onStarted()
    fun onSuccess(detail: Detail)
    fun onFailure(message:String)

}