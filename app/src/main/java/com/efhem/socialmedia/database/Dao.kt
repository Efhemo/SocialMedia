package com.efhem.socialmedia.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.efhem.socialmedia.model.UserHistory

@Dao
interface Dao {

    //Insert and get list of competitions
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserHistory(userHistory: UserHistory)

    @Query("SELECT * FROM userhistory")
    fun userHistory(): LiveData<UserHistory>

}