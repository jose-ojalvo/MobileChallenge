package com.jojalvo.settings.features.termsandprivacy.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jojalvo.component.widget.MCToolbarWithNavIcon
import com.jojalvo.framework.base.jetpack.htmltext.HtmlText
import com.jojalvo.provider.NavigationProvider
import com.jojalvo.settings.features.termsandprivacy.privacyPolicy
import com.jojalvo.settings.features.termsandprivacy.termsAndConditions
import com.jojalvo.theme.MobileChallengeColors
import com.jojalvo.theme.MobileChallengeTypography
import com.ramcosta.composedestinations.annotation.Destination
import com.jojalvo.theme.R

/**
 *   @author jojalvo
 *   @since 23/4/23
 *   @email josealejandro025@gmail.com
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun TermsAndPrivacyScreen(
    navigator: NavigationProvider
) {
    Scaffold(
        topBar = {
            MCToolbarWithNavIcon(
                R.string.settings_term_and_privacy,
                pressOnBack = {
                    navigator.navigateUp()
                }
            )
        },
        content = {
            Column(modifier = Modifier.background(MobileChallengeColors.surface)) {
                HtmlText(
                    text = termsAndConditions.plus(privacyPolicy),
                    modifier = Modifier
                        .padding(12.dp)
                        .verticalScroll(rememberScrollState()),
                    style = MobileChallengeTypography.headlineMedium
                )
            }
        }
    )
}