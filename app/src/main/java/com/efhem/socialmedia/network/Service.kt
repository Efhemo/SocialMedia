package com.efhem.socialmedia.network

import com.efhem.socialmedia.model.UserHistory
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface Service {

    @GET("users/{userId}")
    suspend fun profile(
        @Path("userId") userId: String
    ): Response<UserHistory>

}