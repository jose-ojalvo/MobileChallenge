package com.jojalvo.users.detail.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jojalvo.users.detail.viewmodel.UserDetailViewModel
import com.jojalvo.theme.R
import com.jojalvo.entity.user.Result
import com.jojalvo.theme.Red700
import com.jojalvo.theme.White
import com.jojalvo.users.detail.viewmodel.UserDetailUIState
import com.jojalvo.utils.extension.toast

/**
 *   @author jojalvo
 *   @since 2/5/23
 *   @email josealejandro025@gmail.com
 */
@Composable
fun UserDetailButton(
    viewModel: UserDetailViewModel = hiltViewModel(),
    data: Result
) {
    val context = LocalContext.current
    val addedToFav = stringResource(id = R.string.text_user_added_to_favs)
    val removedFromFav = stringResource(id = R.string.text_user_removed_from_favs)
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp, horizontal = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                when (uiState) {
                    is UserDetailUIState.ExistingUser -> {
                        viewModel.removeFromFavorites(data)
                        context.toast(removedFromFav)
                    }
                    else -> {
                        viewModel.addToFavorites(data)
                        context.toast(addedToFav)
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Red700
            ),
            shape = RectangleShape
        ) {
            Text(
                text =
                when (uiState) {
                    is UserDetailUIState.ExistingUser -> {
                        stringResource(id = R.string.text_user_delete_from_favorites)
                    }
                    else -> stringResource(id = R.string.text_user_add_to_favorites)
                },
                color = White,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}
