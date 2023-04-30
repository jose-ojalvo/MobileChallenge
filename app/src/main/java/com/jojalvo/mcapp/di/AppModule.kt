package com.jojalvo.mcapp.di

import android.content.Context
import com.jojalvo.framework.base.application.NetworkConfig
import com.jojalvo.framework.base.pref.CacheManager
import com.jojalvo.mcapp.application.MCApplication
import com.jojalvo.mcapp.application.MCNetworkConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *   @author jojalvo
 *   @since 1/4/23
 *   @email josealejandro025@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesApplication() = MCApplication()

    @Provides
    @Singleton
    fun providesCacheManager(@ApplicationContext context: Context) =
        CacheManager(context)

    @Provides
    @Singleton
    fun provideNetworkConfig(): NetworkConfig =
        MCNetworkConfig()
}