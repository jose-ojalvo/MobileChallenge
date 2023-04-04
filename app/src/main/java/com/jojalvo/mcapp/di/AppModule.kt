package com.jojalvo.mcapp.di

import com.jojalvo.mcapp.application.MCApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
}