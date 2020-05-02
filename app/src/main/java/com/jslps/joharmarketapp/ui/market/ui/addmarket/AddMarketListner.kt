package com.jslps.joharmarketapp.ui.market.ui.addmarket

import androidx.lifecycle.LiveData
import com.jslps.joharmarketapp.data.db.User
import com.jslps.joharmarketapp.data.network.response.Detail

interface AddMarketListner {
    fun onStarted(message: String)
    fun onSuccess()
    fun onFailure(message:String)

}