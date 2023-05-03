package com.jojalvo.repository.favorites

import androidx.annotation.VisibleForTesting
import com.jojalvo.local.dao.favorite.FavoriteDao
import com.jojalvo.model.dto.favorites.toUserDtoList
import com.jojalvo.entity.user.Result
import com.jojalvo.model.dto.favorites.toFavUserEntity
import javax.inject.Inject

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
class FavoritesRepository
@Inject
constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val dao: FavoriteDao
) {
    suspend fun getFavUsers() = dao.getFavUserList().toUserDtoList()

    suspend fun saveUserItem(user: Result?) {
        user?.let {
            dao.insert(user.toFavUserEntity())
        }
    }

    suspend fun deleteUser(title: String, first: String, last: String) =
        dao.deleteItem(title, first, last)
}