package com.jojalvo.repository.users

import androidx.annotation.VisibleForTesting
import com.jojalvo.local.dao.UsersDao
import com.jojalvo.remote.service.users.UsersService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.jojalvo.entity.user.Result
import com.jojalvo.model.dto.users.toUserDtoList

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

    fun getUsersList(cacheData: Boolean = false): Flow<List<Result>> = flow {
        if (cacheData) {
            val dao = dao.getUsersList()
            if (dao.isNotEmpty()) {
                emit(dao.toUserDtoList())
            } else {
                val remoteData = service.getUserList()
                val response = remoteData.results
                if (!response.isNullOrEmpty()) {
                    emit(response.toUserDtoList())
                } else {
                    emit(emptyList())
                }
            }
        }
        val remoteData = service.getUserList()
        val response = remoteData.results
        if (!response.isNullOrEmpty()) {
            emit(response.toUserDtoList())
        } else {
            emit(emptyList())
        }
    }

}