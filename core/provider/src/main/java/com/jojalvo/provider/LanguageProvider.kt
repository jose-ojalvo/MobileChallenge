package com.jojalvo.provider

import android.content.Context

/**
 *   @author jojalvo
 *   @since 18/4/23
 *   @email josealejandro025@gmail.com
 */
interface LanguageProvider {
    fun saveLanguageCode(languageCode: String)
    fun getLanguageCode(): String
    fun setLocale(language: String, context: Context)
}