package com.jojalvo.usecase.di

import com.jojalvo.repository.onboarding.OnBoardingRepository
import com.jojalvo.usecase.onboarding.ReadOnBoarding
import com.jojalvo.usecase.onboarding.SaveOnBoarding
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *   @author jojalvo
 *   @since 13/4/23
 *   @email josealejandro025@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
class OnBoardingModule {

    @Singleton
    @Provides
    fun providesSaveOnBoarding(repository: OnBoardingRepository) =
        SaveOnBoarding(repository)

    @Singleton
    @Provides
    fun providesReadOnBoarding(repository: OnBoardingRepository) =
        ReadOnBoarding(repository)

}