@file:Suppress("DEPRECATION")

package com.jojalvo.utils.extension

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build.FINGERPRINT
import android.os.Build.MODEL
import android.os.Build.MANUFACTURER
import android.os.Build.DEVICE
import android.os.Build.BRAND
import android.os.Build.PRODUCT
import android.provider.Settings
import android.provider.Settings.Global.DEVELOPMENT_SETTINGS_ENABLED
import android.provider.Settings.Secure

/**
 *   @author jojalvo
 *   @since 23/4/23
 *   @email josealejandro025@gmail.com
 */

fun Context.appVersion(): String {
    return try {
        packageManager.getPackageInfo(packageName, 0).versionName
    } catch (ex: PackageManager.NameNotFoundException) {
        ""
    }
}

fun isEmulator(): Boolean {
    return (FINGERPRINT.startsWith("generic")
            || FINGERPRINT.startsWith("unknown")
            || MODEL.contains("google_sdk")
            || MODEL.contains("Emulator")
            || MODEL.contains("Android SDK built for x86")
            || MANUFACTURER.contains("Genymotion")
            || MODEL.startsWith("sdk_")
            || DEVICE.startsWith("emulator")
            || BRAND.startsWith("generic") && DEVICE.startsWith("generic")
            || "google_sdk" == PRODUCT)
}

fun Context.developerEnabled(): Boolean =
    Secure.getInt(
        this.contentResolver,
        DEVELOPMENT_SETTINGS_ENABLED,
        0
    ) != 0

@SuppressLint("HardwareIds")
fun Context.deviceId(): String {
    val androidId = Secure.getString(contentResolver, Secure.ANDROID_ID)
    return androidId.orEmpty()
}