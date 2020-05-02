package com.jslps.joharmarketapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DashboardDao {
//    @Query("SELECT * from User WHERE id=$CURRENT_USER_ID")
//    fun getUser(): LiveData<User>

    @Query("DELETE from User WHERE id=$CURRENT_USER_ID")
    suspend fun deleteUser()
}