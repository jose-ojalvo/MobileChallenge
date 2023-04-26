package com.jojalvo.mcapp.application

import com.jojalvo.framework.base.application.NetworkConfig
import com.jojalvo.mcapp.BuildConfig

/**
 *   @author jojalvo
 *   @since 26/4/23
 *   @email josealejandro025@gmail.com
 */
class MCNetworkConfig : NetworkConfig() {

    override fun baseUrl(): String =
        BuildConfig.BASE_URL

    override fun timeOut(): Long =
        30L

    override fun isDev(): Boolean =
        BuildConfig.DEBUG
}