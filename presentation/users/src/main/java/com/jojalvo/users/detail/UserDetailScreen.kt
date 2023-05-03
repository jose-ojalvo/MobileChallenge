package com.jojalvo.users.detail

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.jojalvo.component.widget.MCToolbarWithNavIcon
import com.jojalvo.entity.user.Result
import com.jojalvo.provider.NavigationProvider
import com.jojalvo.theme.MobileChallengeColors
import com.jojalvo.theme.MobileChallengeTheme
import com.jojalvo.theme.R
import com.jojalvo.users.detail.view.UserDetailContent
import com.jojalvo.users.detail.viewmodel.UserDetailViewModel
import com.ramcosta.composedestinations.annotation.Destination

/**
 *   @author jojalvo
 *   @since 1/5/23
 *   @email josealejandro025@gmail.com
 */
@Destination(start = true)
@Composable
fun UserDetailScreen(
    user: Result? = null,
    viewModel: UserDetailViewModel = hiltViewModel(),
    navigator: NavigationProvider
) {
    viewModel.searchExistingUsers(user!!)
    UserDetailBody(
        pressOnBack = {
            navigator.navigateUp()
        }
    ) {
        UserDetailContent(
            data = user
        )
    }
}

@Composable
fun UserDetailBody(
    pressOnBack: () -> Unit = {},
    pageContent: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        backgroundColor = MobileChallengeColors.background,
        topBar = {
            MCToolbarWithNavIcon(
                R.string.toolbar_user_detail_title,
                pressOnBack = pressOnBack
            )
        },
        content = { pageContent.invoke(it) }
    )
}

@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun ProductDetailScreenPreview() {
    MobileChallengeTheme {
        Surface {
            UserDetailBody {}
        }
    }
}