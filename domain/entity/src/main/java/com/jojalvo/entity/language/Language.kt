package com.jojalvo.entity.language

/**
 *   @author jojalvo
 *   @since 23/4/23
 *   @email josealejandro025@gmail.com
 */
data class Language(
    val id: Int,
    val code: String,
    val name: String,
    var isSelected: Boolean = false
)