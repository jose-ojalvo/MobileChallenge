package com.jojalvo.remote.service.users

import com.jojalvo.model.remote.users.UsersResponse
import retrofit2.http.GET

/**
 *   @author jojalvo
 *   @since 25/4/23
 *   @email josealejandro025@gmail.com
 */
interface UsersService {

    @GET(USERS)
    suspend fun getUserList(): UsersResponse

    companion object {
        const val USERS = "results=20"
    }

}