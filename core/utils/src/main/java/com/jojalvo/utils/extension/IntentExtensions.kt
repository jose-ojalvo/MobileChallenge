package com.jojalvo.utils.extension

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.core.app.ShareCompat
import com.jojalvo.constants.StoreConstants.AMAZON_APP_MARKET_URL
import com.jojalvo.constants.StoreConstants.APP_GALLERY_URL
import com.jojalvo.constants.StoreConstants.MARKET_URL
import com.jojalvo.constants.StoreConstants.PLAY_STORE_URL

/**
 *   @author jojalvo
 *   @since 14/4/23
 *   @email josealejandro025@gmail.com
 */

fun Activity.launchActivity(
    packageName: String,
    className: String,
    flags: Int = -1,
    bundle: Bundle? = null
) {
    val intent = Intent(Intent.ACTION_VIEW).setClassName(packageName, className)
    if (flags != -1) {
        intent.flags = flags
    }
    bundle?.let {
        intent.putExtras(it)
    }
    startActivity(intent)
}

fun Context.getActivity(): Activity? {
    if (this is ContextWrapper) {
        return this as? Activity
    }
    return null
}

/**
 * Following methods are related to Store behaviour, since this is an App Challenge this code
 * will never be used as this app won't be released in the store, this methods were created
 * to show business related knowledge with different stores
 */

@SuppressLint("QueryPermissionsNeeded")
fun Context.rateOnGooglePlay() {
    Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse(MARKET_URL + packageName)
        packageManager?.let { packageManager ->
            resolveActivity(packageManager)?.let {
                startActivity(this)
            }
        }
    }
}

@SuppressLint("QueryPermissionsNeeded")
fun Context.shareApplication() {
    val shareIntent = getActivity()?.let {
        ShareCompat.IntentBuilder(it)
            .setType("text/plain")
            .setText(
                PLAY_STORE_URL + packageName
            ).intent
    }
    if (shareIntent?.resolveActivity(packageManager) != null) {
        startActivity(shareIntent)
    }
}

fun Context.openAppOnPlayStore() = try {
    startActivity(
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse(
                MARKET_URL + packageName
            )
        )
    )
} catch (ex: ActivityNotFoundException) {
    startActivity(
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse(
                PLAY_STORE_URL + packageName
            )
        )
    )
}

/**
 * This method is used to launch either Amazon app or in case it's not installed in the device,
 * the Huawei App Gallery
 */
fun Context.openAppOnAppGallery() {
    try {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(
                    AMAZON_APP_MARKET_URL + packageName
                )
            )
        )
    } catch (e: ActivityNotFoundException) {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse(
                    APP_GALLERY_URL
                )
            )
        )
    }
}