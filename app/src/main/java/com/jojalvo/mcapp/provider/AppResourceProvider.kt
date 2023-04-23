package com.jojalvo.mcapp.provider

import android.content.Context
import com.jojalvo.provider.ResourceProvider

/**
 *   @author jojalvo
 *   @since 23/4/23
 *   @email josealejandro025@gmail.com
 */
class AppResourceProvider(private val context: Context) : ResourceProvider {

    override fun getString(id: Int): String = context.getString(id)
}