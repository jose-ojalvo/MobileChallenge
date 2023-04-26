package com.jojalvo.model.remote.users

import com.jojalvo.entity.user.*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 *   @author jojalvo
 *   @since 25/4/23
 *   @email josealejandro025@gmail.com
 */
@JsonClass(generateAdapter = true)
data class UserResponse(
    @Json(name = "gender") val gender: String?,
    @Json(name = "name") val name: Name?,
    @Json(name = "location") val location: Location?,
    @Json(name = "email") val email: String?,
    @Json(name = "dob") val dob: Dob?,
    @Json(name = "picture") val picture: Picture?
)