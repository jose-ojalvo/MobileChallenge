package com.jojalvo.model.local.favorites

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jojalvo.entity.user.Dob
import com.jojalvo.entity.user.Location
import com.jojalvo.entity.user.Picture
import com.jojalvo.model.local.users.NameEmbedded

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
@Entity(tableName = FavUserEntity.TABLE_NAME)
class FavUserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID) val id: Int?,
    @ColumnInfo(name = GENDER) val gender: String?,
    @Embedded(prefix = NAME) val name: NameEmbedded?,
    @ColumnInfo(name = LOCATION) val location: Location?,
    @ColumnInfo(name = EMAIL) val email: String?,
    @ColumnInfo(name = PHONE) val phone: String?,
    @ColumnInfo(name = DOB) val dob: Dob?,
    @ColumnInfo(name = PICTURE) val picture: Picture?,
) {
    companion object {
        const val TABLE_NAME = "fav_table"
        const val COLUMN_ID = "id"
        const val GENDER = "gender"
        const val NAME = "name_"
        const val LOCATION = "location"
        const val EMAIL = "email"
        const val PHONE = "phone"
        const val DOB = "dob"
        const val PICTURE = "picture"
    }

}