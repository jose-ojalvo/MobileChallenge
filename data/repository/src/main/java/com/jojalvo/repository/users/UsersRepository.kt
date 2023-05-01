package com.jojalvo.repository.users

import androidx.annotation.VisibleForTesting
import com.jojalvo.local.dao.UsersDao
import com.jojalvo.remote.service.users.UsersService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.jojalvo.entity.user.Result
import com.jojalvo.model.dto.users.toUserDtoList
import com.jojalvo.model.dto.users.toUserEntityList

/**
 *   @author jojalvo
 *   @since 27/4/23
 *   @email josealejandro025@gmail.com
 */
class UsersRepository
@Inject
constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val service: UsersService,
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val dao: UsersDao
) {
    fun getRemoteCachedUserList(): Flow<List<Result>> = flow {
        val localData = dao.getUsersList()
        if (localData.isNotEmpty()) {
            emit(localData.toUserDtoList())
        } else {
            val remoteData = service.getUserList()
            val response = remoteData.results
            if (!response.isNullOrEmpty()) {
                dao.insert(response.toUserEntityList())
                emit(response.toUserDtoList())
            } else {
                emit(emptyList())
            }
        }
    }

    fun getUpdatedUserList(): Flow<List<Result>> = flow {
        val remoteData = service.getUserList()
        val response = remoteData.results
        if (!response.isNullOrEmpty()) {
            dao.clearData()
            dao.insert(response.toUserEntityList())
            emit(response.toUserDtoList())
        } else {
            emit(emptyList())
        }
    }

    suspend fun getLocalUserList() = dao.getUsersList()
}