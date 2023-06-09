package com.jojalvo.mcapp.di

import android.content.Context
import com.jojalvo.framework.base.pref.CacheManager
import com.jojalvo.mcapp.provider.AppLanguageProvider
import com.jojalvo.mcapp.provider.AppResourceProvider
import com.jojalvo.mcapp.provider.AppThemeProvider
import com.jojalvo.provider.LanguageProvider
import com.jojalvo.provider.ResourceProvider
import com.jojalvo.provider.ThemeProvider
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
class ProviderModule {

    @Provides
    @Singleton
    fun provideAppResourceProvider(@ApplicationContext context: Context): ResourceProvider =
        AppResourceProvider(context)

    @Provides
    @Singleton
    fun provideAppLanguageProvider(cacheManager: CacheManager): LanguageProvider =
        AppLanguageProvider(cacheManager)

    @Provides
    @Singleton
    fun providesAppThemeProvider(@ApplicationContext context: Context): ThemeProvider =
        AppThemeProvider(context)

}