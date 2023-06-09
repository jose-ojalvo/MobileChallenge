package com.jojalvo.model.dto.users

import com.jojalvo.entity.user.Name
import com.jojalvo.entity.user.Result
import com.jojalvo.model.local.users.NameEmbedded
import com.jojalvo.model.local.users.UserEntity
import com.jojalvo.model.remote.users.UserResponse

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
    name = name?.toNameEmbedded(),
    location = location,
    email = email,
    dob = dob,
    picture = picture,
    phone = phone
)

fun UserEntity.toUserDto() = Result(
    gender = gender.orEmpty(),
    name = name?.toName(),
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

fun Name.toNameEmbedded() = NameEmbedded(
    title = title,
    first = first,
    last = last
)

fun NameEmbedded.toName() = Name(
    title = title,
    first = first,
    last = last
)

@JvmName("toUserResponseListUserEntity")
fun List<UserResponse>.toUserEntityList() = map { it.toUserEntity() }

@JvmName("toUserDtoListUserResponse")
fun List<UserResponse>.toUserDtoList() = map { it.toUserDto() }

@JvmName("toUserDtoListUserEntity")
fun List<UserEntity>.toUserDtoList() = map { it.toUserDto() }