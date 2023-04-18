package com.jojalvo.framework.base.pref

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV
import androidx.security.crypto.EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import androidx.security.crypto.MasterKey.KeyScheme

/**
 *   @author jojalvo
 *   @since 18/4/23
 *   @email josealejandro025@gmail.com
 *
 * @param fileName Name of the Shared Preferences
 * @return SharedPreferences
 */
fun Context.getPrefs(fileName: String? = null): SharedPreferences {
    val masterKey = MasterKey.Builder(this)
        .setKeyScheme(KeyScheme.AES256_GCM)
        .build()

    val name = if (fileName.isNullOrEmpty()) {
        getDefaultSharedPrefName()
    } else {
        fileName.toString()
    }

    return EncryptedSharedPreferences.create(
        this,
        name,
        masterKey,
        AES256_SIV,
        AES256_GCM
    )
}

/**
 * @return Default SharedPreferences filename
 */
fun Context.getDefaultSharedPrefName(): String {
    return this.packageName + "_pref"
}