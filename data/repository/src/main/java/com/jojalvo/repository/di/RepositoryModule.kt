package com.jojalvo.repository.di

import android.content.Context
import com.jojalvo.local.dao.favorite.FavoriteDao
import com.jojalvo.local.dao.user.UsersDao
import com.jojalvo.remote.service.users.UsersService
import com.jojalvo.repository.favorites.FavoritesRepository
import com.jojalvo.repository.onboarding.OnBoardingRepository
import com.jojalvo.repository.users.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *   @author jojalvo
 *   @since 13/4/23
 *   @email josealejandro025@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesOnBoardingRepository(
        @ApplicationContext context: Context
    ) = OnBoardingRepository(context)

    @Singleton
    @Provides
    fun providesUsersRepository(
        service: UsersService,
        dao: UsersDao
    ) = UsersRepository(service, dao)

    @Singleton
    @Provides
    fun providesFavoritesRepository(dao: FavoriteDao) = FavoritesRepository(dao)

}