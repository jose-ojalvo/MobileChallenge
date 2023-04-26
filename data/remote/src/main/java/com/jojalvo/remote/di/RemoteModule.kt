package com.jojalvo.remote.di

import com.jojalvo.framework.base.application.NetworkConfig
import com.jojalvo.framework.base.network.createMoshi
import com.jojalvo.framework.base.network.createRetrofitWithMoshi
import com.jojalvo.remote.service.users.UsersService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton

/**
 *   @author jojalvo
 *   @since 25/4/23
 *   @email josealejandro025@gmail.com
 */

private const val BASE_URL = "base_url"

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        createMoshi()

    @Provides
    @Singleton
    @Named(value = BASE_URL)
    fun providesBaseUrl(networkConfig: NetworkConfig) =
        networkConfig.baseUrl()

    @Provides
    @Singleton
    fun provideUsersService(
        @Named(value = BASE_URL) baseUrl: String,
        okHttpClient: OkHttpClient,
        moshi: Moshi
    ): UsersService {
        return createRetrofitWithMoshi(
            okHttpClient = okHttpClient,
            moshi = moshi,
            baseUrl = baseUrl
        )
    }

}