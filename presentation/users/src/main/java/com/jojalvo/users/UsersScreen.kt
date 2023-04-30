@file:OptIn(ExperimentalMaterialApi::class, ExperimentalMaterialApi::class)

package com.jojalvo.users

import android.content.res.Configuration
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jojalvo.component.widget.EmptyView
import com.jojalvo.component.widget.ErrorView
import com.jojalvo.component.widget.LoadingView
import com.jojalvo.component.widget.MCToolbar
import com.jojalvo.provider.NavigationProvider
import com.jojalvo.theme.MobileChallengeColors
import com.jojalvo.theme.MobileChallengeTheme
import com.jojalvo.theme.R
import com.jojalvo.users.view.UsersContent
import com.jojalvo.users.viewmodel.UsersUIState
import com.jojalvo.users.viewmodel.UsersViewModel
import com.jojalvo.utils.extension.cast
import com.ramcosta.composedestinations.annotation.Destination

/**
 *   @author jojalvo
 *   @since 24/4/23
 *   @email josealejandro025@gmail.com
 */
@Composable
fun UsersScreen(
    modifier: Modifier,
    viewModel: UsersViewModel = hiltViewModel(),
    bottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    ),
    navigator: NavigationProvider
) {

    val uiState by viewModel.uiState.collectAsState()

    UsersBody(
        modifier, bottomSheetState
    ) { padding ->
        Column {
            UsersPage(uiState, viewModel, padding, navigator, modifier)
        }
    }
}

@Composable
fun UsersPage(
    uiState: UsersUIState<*>,
    viewModel: UsersViewModel,
    paddings: PaddingValues,
    navigator: NavigationProvider,
    modifier: Modifier
) {
    when (uiState) {
        is UsersUIState.UsersData -> UsersContent(
            viewModel = viewModel,
            paddingValues = paddings,
            viewState = uiState.cast<UsersUIState.UsersData<UsersViewState>>().result,
            selectItem = {
                //TODO: Open user detail
            },
        )
        is UsersUIState.Error -> {
            ErrorView(
                e = uiState.cast<UsersUIState.Error>().throwable,
                action = { viewModel.getUsers() }
            )
        }
        is UsersUIState.Empty -> EmptyView(modifier = Modifier)
        is UsersUIState.Loading -> LoadingView()
    }
    LaunchedEffect(key1 = viewModel, block = { viewModel.getUsers() })
}

@Composable
fun UsersBody(
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
                topBar = { MCToolbar(titleString = R.string.bottom_menu_users, elevation = 0.dp) },
                content = { pageContent.invoke(it) }
            )
        }
    )
}

@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun UsersScreenPreview() {
    MobileChallengeTheme {
        Surface {}
    }
}