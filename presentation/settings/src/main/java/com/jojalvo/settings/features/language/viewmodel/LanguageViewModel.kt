package com.jojalvo.settings.features.language.viewmodel

import androidx.compose.runtime.mutableStateOf
import com.jojalvo.entity.language.Language
import com.jojalvo.framework.base.mvvm.MvvmViewModel
import com.jojalvo.provider.LanguageProvider
import com.jojalvo.provider.ResourceProvider
import javax.inject.Inject
import com.jojalvo.theme.R
import dagger.hilt.android.lifecycle.HiltViewModel

/**
 *   @author jojalvo
 *   @since 23/4/23
 *   @email josealejandro025@gmail.com
 */
@HiltViewModel
class LanguageViewModel @Inject constructor(
    private val languageProvider: LanguageProvider,
    private val resourceProvider: ResourceProvider
) : MvvmViewModel() {

    private var languages = emptyList<Language>()
    val langs = mutableStateOf<List<Language>>(emptyList())

    init {
        languages = getLanguages()
        getLanguage()
    }

    fun saveLanguage(code: String) {
        languageProvider.saveLanguageCode(code)
    }

    private fun getLanguage() {
        languages.map {
            it.isSelected = it.code == getLanguageCode()
        }
        langs.value = languages
    }

    private fun getLanguageCode(): String =
        languageProvider.getLanguageCode()

    private fun getLanguages(): List<Language> {
        return listOf(
            Language(
                id = 1,
                code = "en",
                name = resourceProvider.getString(R.string.text_language_english),
                isSelected = false
            ),
            Language(
                id = 2,
                code = "es",
                name = resourceProvider.getString(R.string.text_language_spanish),
                isSelected = false
            )
        )
    }

}