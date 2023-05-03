@file:OptIn(ExperimentalMaterialApi::class, ExperimentalMaterialApi::class)

package com.jojalvo.favorites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jojalvo.component.widget.EmptyView
import com.jojalvo.component.widget.ErrorView
import com.jojalvo.component.widget.LoadingView
import com.jojalvo.component.widget.MCToolbar
import com.jojalvo.favorites.view.FavoritesContent
import com.jojalvo.favorites.viewmodel.FavoritesUIState
import com.jojalvo.favorites.viewmodel.FavoritesViewModel
import com.jojalvo.provider.NavigationProvider
import com.jojalvo.theme.MobileChallengeColors
import com.jojalvo.theme.R
import com.jojalvo.utils.extension.cast

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
@Composable
fun FavoritesScreen(
    modifier: Modifier,
    viewModel: FavoritesViewModel = hiltViewModel(),
    bottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    ),
    navigator: NavigationProvider
) {
    val uiState by viewModel.uiState.collectAsState()

    FavoritesBody(
        modifier, bottomSheetState
    ) { padding ->
        Column {
            FavoritesPage(uiState, viewModel, padding, navigator, modifier)
        }
    }
}

@Composable
fun FavoritesPage(
    uiState: FavoritesUIState<*>,
    viewModel: FavoritesViewModel,
    paddings: PaddingValues,
    navigator: NavigationProvider,
    modifier: Modifier
) {
    when (uiState) {
        is FavoritesUIState.UsersData -> FavoritesContent(
            viewModel = viewModel,
            paddingValues = paddings,
            viewState = uiState.cast<FavoritesUIState.UsersData<FavoritesViewState>>().result,
            selectItem = { navigator.openDetail(it) },
        )
        is FavoritesUIState.Error -> {
            ErrorView(
                e = uiState.cast<FavoritesUIState.Error>().throwable,
                action = { viewModel.getFavUsers() }
            )
        }
        is FavoritesUIState.Empty -> EmptyView(modifier = Modifier)
        is FavoritesUIState.Loading -> LoadingView()
    }
    LaunchedEffect(key1 = viewModel, block = { viewModel.getFavUsers() })
}

@Composable
fun FavoritesBody(
    modifier: Modifier = Modifier,
    bottomSheetState: ModalBottomSheetState,
    pageContent: @Composable (PaddingValues) -> Unit
) {
    ModalBottomSheetLayout(
        sheetContent = {},
        modifier = modifier
            .fillMaxSize()
            .background(MobileChallengeColors.background),
        sheetState = bottomSheetState,
        sheetContentColor = MobileChallengeColors.background,
        sheetShape = RectangleShape,
        content = {
            Scaffold(
                topBar = { MCToolbar(titleString = R.string.bottom_menu_fav, elevation = 0.dp) },
                content = { pageContent.invoke(it) }
            )
        }
    )
}