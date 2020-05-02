package com.jslps.joharmarketapp.data.network.response

import com.jslps.joharmarketapp.data.db.User

data class LoginResponse(
    val isSuccessful: Boolean,
    val message: String,
    val user: User?
)