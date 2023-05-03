package com.jojalvo.model.dto.favorites

import com.jojalvo.entity.user.Result
import com.jojalvo.model.dto.users.toName
import com.jojalvo.model.dto.users.toNameEmbedded
import com.jojalvo.model.local.favorites.FavUserEntity

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
fun Result.toFavUserEntity() = FavUserEntity(
    gender = gender,
    name = name?.toNameEmbedded(),
    location = location,
    email = email,
    dob = dob,
    phone = phone,
    id = null,
    picture = picture,
)

fun FavUserEntity.toUserItem() = Result(
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

fun List<FavUserEntity>.toUserDtoList() = map { it.toUserItem() }