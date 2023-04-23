package com.jojalvo.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.jojalvo.component.widget.MCToolbar
import com.jojalvo.provider.NavigationProvider
import com.jojalvo.settings.view.SettingsContent
import com.jojalvo.settings.viewmodel.SettingsViewModel
import com.jojalvo.theme.MobileChallengeTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.jojalvo.theme.R

/**
 *   @author jojalvo
 *   @since 22/4/23
 *   @email josealejandro025@gmail.com
 */
@Destination(start = true)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel(),
    navigator: NavigationProvider
) {
    val themeState = remember { mutableStateOf(viewModel.isNightMode()) }
    SettingsBody(modifier) {
        SettingsContent(viewModel, themeState, navigator)
    }
}

@Composable
fun SettingsBody(
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = { MCToolbar(R.string.bottom_menu_settings) },
        content = { content.invoke(it) }
    )
}

@Preview
@Composable
fun SettingsScreenPreview() {
    MobileChallengeTheme {
        Surface {
            SettingsBody {}
        }
    }
}