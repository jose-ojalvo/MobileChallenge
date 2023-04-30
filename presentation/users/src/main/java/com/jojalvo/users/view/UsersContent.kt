@file:Suppress("DEPRECATION")

package com.jojalvo.users.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import androidx.compose.material.CircularProgressIndicator
import com.jojalvo.framework.base.jetpack.rememberFlowWithLifecycle
import com.jojalvo.theme.MobileChallengeColors
import com.jojalvo.users.UsersViewState
import com.jojalvo.users.viewmodel.UsersViewModel

/**
 *   @author jojalvo
 *   @since 30/4/23
 *   @email josealejandro025@gmail.com
 */
@Composable
fun UsersContent(
    viewModel: UsersViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    viewState: UsersViewState,
    selectItem: (Int) -> Unit = {}
) {
    val pagingItems = rememberFlowWithLifecycle(viewState.pagedData).collectAsLazyPagingItems()

    SwipeRefresh(
        state = rememberSwipeRefreshState(
            isRefreshing = pagingItems.loadState.refresh == LoadState.Loading
        ),
        onRefresh = { viewModel.getUsers() },
        indicatorPadding = paddingValues,
        indicator = { state, trigger ->
            SwipeRefreshIndicator(
                state = state,
                refreshTriggerDistance = trigger,
                scale = true
            )
        },
        modifier = Modifier.background(MobileChallengeColors.background),
        content = {
            LazyColumn(
                contentPadding = paddingValues,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 4.dp)
                    .background(MobileChallengeColors.background),
            ) {
                items(pagingItems.itemCount) { index ->
                    pagingItems[index]?.let {
                        UserRow(
                            viewModel,
                            dto = it,
                            onDetailClick = {  }
                        )
                    }
                }

                if (pagingItems.loadState.append == LoadState.Loading) {
                    item {
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .padding(24.dp)
                        ) {
                            CircularProgressIndicator(Modifier.align(Alignment.Center))
                        }
                    }
                }
            }
        }
    )
}

