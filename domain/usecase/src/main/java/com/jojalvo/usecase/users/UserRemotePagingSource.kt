package com.jojalvo.usecase.users

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jojalvo.entity.user.Result
import com.jojalvo.repository.users.UsersRepository
import java.io.IOException

/**
 *   @author jojalvo
 *   @since 1/5/23
 *   @email josealejandro025@gmail.com
 */
class UserRemotePagingSource(
    private val repository: UsersRepository
) : PagingSource<Int, Result>() {

    /**
     * The refresh key is used for subsequent refresh calls to PagingSource.load
     * after the initial load
     */
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        // The first page will be null so we'll set 1 as a default placeholder value
        //TODO: Enable paging user data
        val page = params.key ?: 1
        return try {
            val userList = mutableListOf<Result>()
            repository.getUpdatedUserList().collect { userList.addAll(it) }
            LoadResult.Page(
                data = userList,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (userList.isEmpty()) null else page + 1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        }
    }
}