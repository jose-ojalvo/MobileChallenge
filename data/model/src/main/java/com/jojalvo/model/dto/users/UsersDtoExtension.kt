package com.jojalvo.model.dto.users

import com.jojalvo.model.local.users.UserEntity
import com.jojalvo.model.remote.users.UserResponse
import com.jojalvo.entity.user.Result

/**
 *   @author jojalvo
 *   @since 25/4/23
 *   @email josealejandro025@gmail.com
 */

fun UserResponse.toUserDto() = Result(
    gender = gender.orEmpty(),
    name = name,
    location = location,
    email = email.orEmpty(),
    login = null,
    dob = dob,
    registered = null,
    phone = phone.orEmpty(),
    cell = String(),
    id = null,
    picture = picture,
    nat = String()
)

fun UserResponse.toUserEntity() = UserEntity(
    id = null,
    gender = gender,
    name = name,
    location = location,
    email = email,
    dob = dob,
    picture = picture,
    phone = phone
)

fun UserEntity.toUserDto() = Result(
    gender = gender.orEmpty(),
    name = name,
    location = location,
    email = email.orEmpty(),
    login = null,
    dob = dob,
    registered = null,
    phone = phone.orEmpty(),
    cell = String(),
    id = null,
    picture = picture,
    nat = String()
)

@JvmName("toUserResponseListUserEntity")
fun List<UserResponse>.toUserEntityList() =
    map {
        it.toUserEntity()
    }.sortedWith(
        compareBy<UserEntity>
        {
            it.name?.first
        }.thenBy {
            it.name?.last
        }
    )

@JvmName("toUserDtoListUserResponse")
fun List<UserResponse>.toUserDtoList() =
    map {
        it.toUserDto()
    }.sortedWith(
        compareBy<Result>
        {
            it.name?.first
        }.thenBy {
            it.name?.last
        }
    )

@JvmName("toUserDtoListUserEntity")
fun List<UserEntity>.toUserDtoList() =
    map {
        it.toUserDto()
    }.sortedWith(
        compareBy<Result>
        {
            it.name?.first
        }.thenBy {
            it.name?.last
        }
    )