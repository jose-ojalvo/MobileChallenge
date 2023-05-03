package com.jojalvo.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jojalvo.local.converter.*
import com.jojalvo.local.dao.favorite.FavoriteDao
import com.jojalvo.local.dao.user.UsersDao
import com.jojalvo.model.local.favorites.FavUserEntity
import com.jojalvo.model.local.users.UserEntity

/**
 *   @author jojalvo
 *   @since 26/4/23
 *   @email josealejandro025@gmail.com
 */
@Database(
    entities = [UserEntity::class, FavUserEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    value = [
        StringListConverter::class,
        StreetConverter::class,
        CoordinatesConverter::class,
        TimezoneConverter::class,
        LocationConverter::class,
        DobConverter::class,
        PictureConverter::class
    ]
)
abstract class MCDatabase : RoomDatabase() {

    abstract fun userDao(): UsersDao

    abstract fun favoriteDao(): FavoriteDao

}