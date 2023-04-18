package com.jojalvo.mcapp.provider

import android.content.Context
import com.jojalvo.framework.base.pref.CacheManager
import com.jojalvo.provider.LanguageProvider
import java.util.*

/**
 *   @author jojalvo
 *   @since 18/4/23
 *   @email josealejandro025@gmail.com
 */
class AppLanguageProvider constructor(private val cacheManager: CacheManager) : LanguageProvider {

    companion object {
        private const val LANG_CODE = "lang_code"
        private const val DefaultLanguage = "en"
    }

    override fun saveLanguageCode(languageCode: String) {
        cacheManager.write(key = LANG_CODE, value = languageCode)
    }

    override fun getLanguageCode(): String {
        return cacheManager.read(key = LANG_CODE, DefaultLanguage)
    }

    override fun setLocale(language: String, context: Context) {
        updateResources(language, context)
    }

    private fun updateResources(language: String, context: Context) {
        val locale = Locale(language)
        val resources = context.resources
        val configuration = resources.configuration
        configuration.setLocale(locale)
        context.createConfigurationContext(configuration)
    }

}