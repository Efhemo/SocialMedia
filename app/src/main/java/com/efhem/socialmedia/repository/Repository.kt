package com.efhem.socialmedia.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.efhem.socialmedia.database.SocialMediaDatabase
import com.efhem.socialmedia.model.UserHistory
import com.efhem.socialmedia.network.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException


class Repository(private val database: SocialMediaDatabase) {

    private val TAG = Repository::class.java.name


    suspend fun userHistory(userId: String) = withContext(Dispatchers.IO) {

        try {
            val response = Network.service.profile(userId)

            if (response.isSuccessful) {

                val userHistory: UserHistory? = response.body()
                Log.d("SocialMedia 2", userHistory.toString())

                userHistory?.let {
                    Log.d("SocialMedia", it.details?.avatar)

                    database.dao.insertUserHistory(userHistory)
                }
            } else {
                Log.d("SocialMedia", response.message())
                null
            }
        } catch (e: HttpException) {
            Log.i(TAG, "message 2 is $e.message()")
            null
        } catch (e: Exception) {
            Log.i(TAG, "message 3 $e.message")
            null
        }
    }


    //database
    fun userhistory(): LiveData<UserHistory> = database.dao.userHistory()


}