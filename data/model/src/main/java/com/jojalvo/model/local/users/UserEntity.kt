package com.jojalvo.model.local.users

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jojalvo.entity.user.Dob
import com.jojalvo.entity.user.Location
import com.jojalvo.entity.user.Name
import com.jojalvo.entity.user.Picture

/**
 *   @author jojalvo
 *   @since 25/4/23
 *   @email josealejandro025@gmail.com
 */
@Entity(tableName = UserEntity.TABLE_NAME)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID) val id: Int?,
    @ColumnInfo(name = GENDER) val gender: String?,
    @ColumnInfo(name = NAME) val name: Name?,
    @ColumnInfo(name = LOCATION) val location: Location?,
    @ColumnInfo(name = EMAIL) val email: String?,
    @ColumnInfo(name = DOB) val dob: Dob?,
    @ColumnInfo(name = PICTURE) val picture: Picture?,
) {
    companion object {
        const val TABLE_NAME = "user_table"
        const val COLUMN_ID = "id"
        const val GENDER = "gender"
        const val NAME = "name"
        const val LOCATION = "location"
        const val EMAIL = "email"
        const val DOB = "dob"
        const val PICTURE = "picture"
    }

}