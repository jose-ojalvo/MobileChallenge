package com.jojalvo.utils.extension

/**
 *   @author jojalvo
 *   @since 19/4/23
 *   @email josealejandro025@gmail.com
 */
val Any.classTag: String get() = this.javaClass.canonicalName.orEmpty()

inline fun <reified T : Any> Any.cast(): T {
    return this as T
}