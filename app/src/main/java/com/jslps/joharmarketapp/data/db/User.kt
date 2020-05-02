package com.jslps.joharmarketapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

const val CURRENT_USER_ID = 0

@Entity
data class User(
    val name:String,
    val password:String,
    val user_id:Int?,
    val role:String?,
    val address:String?

): Serializable {
    @PrimaryKey(autoGenerate = false) // this is false only to store one user
    var id: Int = CURRENT_USER_ID
}

//serialization is used when this class is passed to next class as argumnets better to keep it
