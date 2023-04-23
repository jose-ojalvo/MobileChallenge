package com.jojalvo.settings.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.jojalvo.component.widget.MCDivider
import com.jojalvo.component.widget.ThemeSwitch
import com.jojalvo.framework.base.jetpack.clickableSingle
import com.jojalvo.provider.NavigationProvider
import com.jojalvo.settings.viewmodel.SettingsViewModel
import com.jojalvo.theme.*
import com.jojalvo.theme.R
import com.jojalvo.utils.extension.appVersion

/**
 *   @author jojalvo
 *   @since 23/4/23
 *   @email josealejandro025@gmail.com
 */
@Composable
fun SettingsContent(
    viewModel: SettingsViewModel = hiltViewModel(),
    checkedState: MutableState<Boolean>,
    navigator: NavigationProvider? = null
) {
    val context = LocalContext.current
    val version = context.appVersion()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MobileChallengeColors.background),
        contentAlignment = Alignment.TopStart
    ) {
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            colors = CardDefaults.cardColors(
                containerColor = MobileChallengeColors.surface
            )
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .padding(16.dp)
                    .background(Transparent)
            ) {
                val (
                    lblThemeMode,
                    switchThemeMode,
                    viewDivider1,
                    lblAppLanguage,
                    viewDivider2,
                    lblAbout,
                    viewDivider3,
                    lblTermAndPrivacy,
                    viewDivider4,
                    lblAppVersion,
                    tvAppVersion
                ) = createRefs()

                Text(
                    text = stringResource(id = R.string.settings_theme_mode),
                    style = MobileChallengeTypography.bodyMedium,
                    modifier = Modifier.constrainAs(lblThemeMode) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                )

                Box(modifier = Modifier.constrainAs(switchThemeMode) {
                    top.linkTo(lblThemeMode.top)
                    bottom.linkTo(lblThemeMode.bottom)
                    end.linkTo(parent.end)
                }) {
                    AndroidView(
                        factory = { context ->
                            ThemeSwitch(context).apply {
                                isChecked = checkedState.value
                                setOnCheckedChangeListener { _, isChecked ->
                                    checkedState.value = isChecked
                                    viewModel.saveThemeMode(isChecked)
                                }
                            }
                        }
                    )
                }
                MCDivider(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp)
                        .constrainAs(viewDivider1) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(lblThemeMode.bottom)
                            height = Dimension.fillToConstraints
                        }
                )
                Row(
                    modifier = Modifier
                        .constrainAs(lblAppLanguage) {
                            top.linkTo(viewDivider1.bottom)
                            start.linkTo(parent.start)
                        }
                        .clickableSingle {
                            navigator?.openAppLanguage()
                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.settings_app_language),
                        style = MobileChallengeTypography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )

                    Icon(
                        painter = rememberVectorPainter(Icons.Default.KeyboardArrowRight),
                        contentDescription = null,
                        tint = Gray400,
                        modifier = Modifier.wrapContentSize()
                    )
                }
                MCDivider(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp)
                        .constrainAs(viewDivider2) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(lblAppLanguage.bottom)
                            height = Dimension.fillToConstraints
                        }
                )
                Row(
                    modifier = Modifier
                        .constrainAs(lblAbout) {
                            top.linkTo(viewDivider2.bottom)
                            start.linkTo(parent.start)
                        }
                        .clickableSingle {
                            navigator?.openAbout()
                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.settings_about),
                        style = MobileChallengeTypography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )

                    Icon(
                        painter = rememberVectorPainter(Icons.Default.KeyboardArrowRight),
                        contentDescription = null,
                        tint = Gray400,
                        modifier = Modifier.wrapContentSize()
                    )
                }
                MCDivider(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp)
                        .constrainAs(viewDivider3) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(lblAbout.bottom)
                            height = Dimension.fillToConstraints
                        }
                )
                Row(
                    modifier = Modifier
                        .constrainAs(lblTermAndPrivacy) {
                            top.linkTo(viewDivider3.bottom)
                            start.linkTo(parent.start)
                        }
                        .clickableSingle {
                            navigator?.openTermAndPrivacy()
                        }
                ) {
                    Text(
                        text = stringResource(id = R.string.settings_term_and_privacy),
                        style = MobileChallengeTypography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    )

                    Icon(
                        painter = rememberVectorPainter(Icons.Default.KeyboardArrowRight),
                        contentDescription = null,
                        tint = Gray400,
                        modifier = Modifier.wrapContentSize()
                    )
                }
                MCDivider(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp)
                        .constrainAs(viewDivider4) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            top.linkTo(lblTermAndPrivacy.bottom)
                            height = Dimension.fillToConstraints
                        }
                )
                Text(
                    text = stringResource(id = R.string.settings_app_version),
                    style = MobileChallengeTypography.bodyMedium,
                    modifier = Modifier.constrainAs(lblAppVersion) {
                        top.linkTo(viewDivider4.bottom)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
                )
                Text(
                    text = version,
                    style = MobileChallengeTypography.titleMedium,
                    modifier = Modifier.constrainAs(tvAppVersion) {
                        top.linkTo(lblAppVersion.top)
                        bottom.linkTo(lblAppVersion.bottom)
                        end.linkTo(parent.end)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsContentPreview() {
    MobileChallengeTheme {
        val checkedState = remember {
            mutableStateOf(true)
        }
        SettingsContent(checkedState = checkedState)
    }
}