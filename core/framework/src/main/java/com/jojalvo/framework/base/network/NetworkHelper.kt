package com.jojalvo.framework.base.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 *   @author jojalvo
 *   @since 26/4/23
 *   @email josealejandro025@gmail.com
 */

fun createMoshi(): Moshi {
    return Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()
}

inline fun <reified T> createRetrofitWithMoshi(
    okHttpClient: OkHttpClient,
    moshi: Moshi,
    baseUrl: String
): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
    return retrofit.create(T::class.java)
}