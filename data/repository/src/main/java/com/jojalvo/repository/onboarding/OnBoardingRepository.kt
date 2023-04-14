package com.jojalvo.repository.onboarding

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.jojalvo.constants.Constants.ON_BOARDING_COMPLETED
import com.jojalvo.constants.Constants.PREFERENCE_ON_BOARDING_REF
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

/**
 *   @author jojalvo
 *   @since 13/4/23
 *   @email josealejandro025@gmail.com
 */
class OnBoardingRepository @Inject constructor(context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
        name = PREFERENCE_ON_BOARDING_REF
    )

    private object PreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = ON_BOARDING_COMPLETED)
    }

    private val dataStore = context.dataStore

    suspend fun writeOnBoardingState(completed: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.onBoardingKey] = completed
        }
    }

    fun readOnBoardingState(): Flow<Boolean> =
        dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            preferences[PreferencesKey.onBoardingKey] ?: false
        }
}