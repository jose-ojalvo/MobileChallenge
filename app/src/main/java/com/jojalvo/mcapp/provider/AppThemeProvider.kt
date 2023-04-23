package com.jojalvo.mcapp.provider

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.jojalvo.framework.base.pref.getPrefs
import com.jojalvo.theme.R
import com.jojalvo.provider.ThemeProvider
import com.jojalvo.provider.ThemeProvider.Theme
import com.jojalvo.provider.ThemeProvider.Theme.LIGHT
import com.jojalvo.provider.ThemeProvider.Theme.DARK
import com.jojalvo.provider.ThemeProvider.Theme.SYSTEM
import kotlinx.coroutines.flow.*

/**
 *   @author jojalvo
 *   @since 20/4/23
 *   @email josealejandro025@gmail.com
 */
class AppThemeProvider constructor(private val context: Context) : ThemeProvider {

    private val sharedPreferences = context.getPrefs()

    private val defaultThemeValue = context.getString(R.string.pref_theme_default_value)

    private val preferenceKeyChangedFlow = MutableSharedFlow<String>(extraBufferCapacity = 1)

    private val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
        preferenceKeyChangedFlow.tryEmit(key)
    }

    companion object {
        const val KEY_THEME = "pref_theme"
    }

    init {
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
    }

    override var theme: Theme
        get() = getThemeForStorageValue(sharedPreferences.getString(KEY_THEME, defaultThemeValue)!!)
        set(value) = sharedPreferences.edit {
            putString(KEY_THEME, value.storageKey)
        }

    override fun observeTheme(): Flow<Theme> {
        return preferenceKeyChangedFlow
            /** Emitting on start allows us to always secure the value we want to get **/
            .onStart { emit(KEY_THEME) }
            /** Filtering any other value the flow may recover **/
            .filter { it == KEY_THEME }
            /** Collecting the value of the theme in a [Theme] variable **/
            .map { theme }
            .distinctUntilChanged()
    }

    override fun isNightMode(): Boolean = theme == DARK

    override fun setNightMode(forceNight: Boolean) {
        theme = if (forceNight) {
            DARK
        } else {
            LIGHT
        }
    }

    private val Theme.storageKey: String
        get() = when (this) {
            LIGHT -> context.getString(R.string.pref_theme_light_value)
            DARK -> context.getString(R.string.pref_theme_dark_value)
            SYSTEM -> context.getString(R.string.pref_theme_system_value)
        }

    private fun getThemeForStorageValue(value: String) = when (value) {
        context.getString(R.string.pref_theme_light_value) -> LIGHT
        context.getString(R.string.pref_theme_dark_value) -> DARK
        else -> SYSTEM
    }


}