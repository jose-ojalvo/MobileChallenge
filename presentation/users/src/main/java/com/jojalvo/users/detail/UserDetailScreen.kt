package com.jojalvo.users.detail

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.jojalvo.provider.NavigationProvider
import com.jojalvo.theme.MobileChallengeTheme
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
    viewModel: UserDetailViewModel = hiltViewModel(),
    navigator: NavigationProvider
) {

    //val uiState by viewModel.uiState.collectAsState()



}

@Composable
fun ProductDetailBody(
    pressOnBack: () -> Unit = {},
    pageContent: @Composable (PaddingValues) -> Unit
) {

}

@Preview(showBackground = true, name = "Light Mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode")
@Composable
fun ProductDetailScreenPreview() {
    MobileChallengeTheme {
        Surface {
            ProductDetailBody {}
        }
    }
}