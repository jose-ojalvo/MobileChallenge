package com.jojalvo.remote.service.users

import com.jojalvo.model.remote.users.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *   @author jojalvo
 *   @since 25/4/23
 *   @email josealejandro025@gmail.com
 */
interface UsersService {

    @GET(".")
    suspend fun getUserList(@Query(USERS) results: Int = 20): UsersResponse

    companion object {
        const val USERS = "results"
    }

}