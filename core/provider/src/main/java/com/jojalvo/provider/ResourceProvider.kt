package com.jojalvo.provider

import androidx.annotation.StringRes

/**
 *   @author jojalvo
 *   @since 23/4/23
 *   @email josealejandro025@gmail.com
 */
interface ResourceProvider {

    fun getString(@StringRes id: Int): String

}