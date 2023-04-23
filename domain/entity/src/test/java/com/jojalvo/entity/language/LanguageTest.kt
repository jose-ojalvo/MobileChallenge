package com.jojalvo.entity.language

import junit.framework.TestCase.assertEquals
import org.junit.Test

/**
 *   @author jojalvo
 *   @since 23/4/23
 *   @email josealejandro025@gmail.com
 */
class LanguageTest {

    @Test
    fun language_checkAttributes_isCreatedSuccessfully() {
        val id = 1
        val code = "en"
        val name = "English"
        val isSelected = false

        val dto = Language(
            id = id,
            code = code,
            name = name,
            isSelected = isSelected
        )

        assertEquals(id, dto.id)
        assertEquals(name, dto.name)
        assertEquals(code, dto.code)
        assertEquals(isSelected, dto.isSelected)
    }
}