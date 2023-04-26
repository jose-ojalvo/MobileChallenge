package com.jojalvo.framework.base.room.dao

import androidx.room.*

/**
 *   @author jojalvo
 *   @since 26/4/23
 *   @email josealejandro025@gmail.com
 */
@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: List<T>)

    @Update
    suspend fun update(data: T)

    @Delete
    suspend fun delete(data: T)

}