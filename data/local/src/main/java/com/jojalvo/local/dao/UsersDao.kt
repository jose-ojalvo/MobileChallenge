package com.jojalvo.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.jojalvo.framework.base.room.dao.BaseDao
import com.jojalvo.model.local.users.UserEntity

/**
 *   @author jojalvo
 *   @since 26/4/23
 *   @email josealejandro025@gmail.com
 */
@Dao
interface UsersDao : BaseDao<UserEntity> {

    @Query("SELECT * FROM ${UserEntity.TABLE_NAME} ORDER BY name")
    suspend fun getUsersList(): List<UserEntity>

}