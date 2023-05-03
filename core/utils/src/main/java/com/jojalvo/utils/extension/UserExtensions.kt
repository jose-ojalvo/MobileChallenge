package com.jojalvo.utils.extension

import com.jojalvo.constants.Constants.SPACE
import com.jojalvo.entity.user.Name
import com.jojalvo.entity.user.Result

/**
 *   @author jojalvo
 *   @since 30/4/23
 *   @email josealejandro025@gmail.com
 */

fun Name.getFullName() =
    title + SPACE + first + SPACE + last

fun Name.getNameSurname() =
    first + SPACE + last

fun Result.equalsByName(other: Result?): Boolean {
    if (this == other) return true
    if (other == null) return false
    return name?.getFullName() == other.name?.getFullName()
}