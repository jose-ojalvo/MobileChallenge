package com.jojalvo.favorites.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.jojalvo.entity.user.Result
import com.jojalvo.favorites.FavoritesViewState
import com.jojalvo.favorites.viewmodel.FavoritesViewModel
import com.jojalvo.framework.base.jetpack.rememberFlowWithLifecycle
import com.jojalvo.theme.MobileChallengeColors

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
@Composable
fun FavoritesContent(
    viewModel: FavoritesViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    viewState: FavoritesViewState,
    selectItem: (Result) -> Unit = {}
) {
    val pagingItems = rememberFlowWithLifecycle(viewState.pagedData).collectAsLazyPagingItems()

    LazyColumn(
        contentPadding = paddingValues,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 4.dp)
            .background(MobileChallengeColors.background),
    ) {
        items(pagingItems.itemCount) { index ->
            pagingItems[index]?.let {
                FavoriteRow(
                    dto = it,
                    onDetailClick = { selectItem.invoke(it) }
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