package com.simplx.apps.courotineapp.api

import com.simplx.apps.courotineapp.pojo.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("placeholder/user/{userId}")
    suspend fun getUsers(
        @Path("userId") userId: String
    ): User
}
