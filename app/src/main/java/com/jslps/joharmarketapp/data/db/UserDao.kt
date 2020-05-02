package com.jslps.joharmarketapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(user:User) : Long


    @Query("SELECT * from User WHERE id=$CURRENT_USER_ID")
    fun getUser():LiveData<User>

}