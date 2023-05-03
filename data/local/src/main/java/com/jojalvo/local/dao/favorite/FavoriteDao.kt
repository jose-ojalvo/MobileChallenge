package com.jojalvo.local.dao.favorite

import androidx.room.Dao
import androidx.room.Query
import com.jojalvo.framework.base.room.dao.BaseDao
import com.jojalvo.model.local.favorites.FavUserEntity

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
@Dao
interface FavoriteDao : BaseDao<FavUserEntity> {

    @Query("SELECT * FROM ${FavUserEntity.TABLE_NAME} ORDER BY name_first, name_last")
    suspend fun getFavUserList(): List<FavUserEntity>

    @Query(
        "DELETE FROM ${FavUserEntity.TABLE_NAME} WHERE name_title = :title AND" +
                " name_first = :first AND " +
                "name_last = :last"
    )
    suspend fun deleteItem(title: String, first: String, last: String)

}