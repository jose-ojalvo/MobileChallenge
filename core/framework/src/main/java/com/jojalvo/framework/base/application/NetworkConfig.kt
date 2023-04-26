package com.jojalvo.framework.base.application

/**
 *   @author jojalvo
 *   @since 26/4/23
 *   @email josealejandro025@gmail.com
 */
abstract class NetworkConfig {

    abstract fun baseUrl(): String

    abstract fun timeOut(): Long

    open fun isDev() = false

}