package com.jojalvo.local.converter

import androidx.room.TypeConverter
import com.jojalvo.utils.extension.fromJson
import com.jojalvo.utils.extension.toJson

/**
 *   @author jojalvo
 *   @since 26/4/23
 *   @email josealejandro025@gmail.com
 */
class StringListConverter {

    @TypeConverter
    fun toListOfStrings(stringValue: String): List<String>? {
        return stringValue.fromJson()
    }

    @TypeConverter
    fun fromListOfStrings(listOfString: List<String>?): String {
        return listOfString.toJson()
    }

}