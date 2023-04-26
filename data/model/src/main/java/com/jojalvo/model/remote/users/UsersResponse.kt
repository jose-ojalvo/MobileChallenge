package com.jojalvo.model.remote.users

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 *   @author jojalvo
 *   @since 25/4/23
 *   @email josealejandro025@gmail.com
 */
@JsonClass(generateAdapter = true)
data class UsersResponse(
    @Json(name = "results") val results: List<UserResponse>
)