package com.jojalvo.usecase.di

import com.jojalvo.repository.users.UsersRepository
import com.jojalvo.usecase.users.GetCachedUsers
import com.jojalvo.usecase.users.GetRemoteUsers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *   @author jojalvo
 *   @since 30/4/23
 *   @email josealejandro025@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
class UsersDomainModule {

    @Singleton
    @Provides
    fun providesGetCachedUsers(repository: UsersRepository): GetCachedUsers =
        GetCachedUsers(repository)

    @Singleton
    @Provides
    fun providesGetRemoteUsers(repository: UsersRepository): GetRemoteUsers =
        GetRemoteUsers(repository)

}