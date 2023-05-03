package com.jojalvo.usecase.di

import com.jojalvo.repository.favorites.FavoritesRepository
import com.jojalvo.usecase.favorites.AddUser
import com.jojalvo.usecase.favorites.DeleteUser
import com.jojalvo.usecase.favorites.ExistsUser
import com.jojalvo.usecase.favorites.GetFavUsers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
class FavoritesDomainModule {

    @Singleton
    @Provides
    fun providesAddUser(repository: FavoritesRepository): AddUser =
        AddUser(repository)

    @Singleton
    @Provides
    fun providesDeleteUser(repository: FavoritesRepository): DeleteUser =
        DeleteUser(repository)

    @Singleton
    @Provides
    fun providesExistsUser(repository: FavoritesRepository): ExistsUser =
        ExistsUser(repository)

    @Singleton
    @Provides
    fun providesFavUsers(repository: FavoritesRepository): GetFavUsers =
        GetFavUsers(repository)

}