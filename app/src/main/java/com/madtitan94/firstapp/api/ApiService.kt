package com.madtitan94.firstapp.api

import com.madtitan94.firstapp.models.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("placeholder/user/{userId}")
    suspend fun getUser(
        @Path("userId") userID : String
    ):User
}
