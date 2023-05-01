package com.jojalvo.settings.features.about.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jojalvo.component.ExtraSmallSpacer
import com.jojalvo.component.MediumSpacer
import com.jojalvo.component.SmallSpacer
import com.jojalvo.component.widget.MCToolbarWithNavIcon
import com.jojalvo.provider.NavigationProvider
import com.jojalvo.theme.*
import com.jojalvo.theme.R
import com.ramcosta.composedestinations.annotation.Destination

/**
 *   @author jojalvo
 *   @since 23/4/23
 *   @email josealejandro025@gmail.com
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun AboutScreen(
    navigator: NavigationProvider
) {
    val uriHandler = LocalUriHandler.current
    val linkedInLink = "https://www.linkedin.com/in/jose-alejandro-ojalvo-prim-65a7b315a/"
    val githubLink = "https://github.com/jose-ojalvo"

    Scaffold(
        backgroundColor = MobileChallengeColors.background,
        topBar = {
            MCToolbarWithNavIcon(
                R.string.settings_about,
                pressOnBack = {
                    navigator.navigateUp()
                }
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MobileChallengeColors.surface
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    shape = MobileChallengeShapes.medium,
                    elevation = CardDefaults.elevatedCardElevation()
                ) {
                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                            .padding(12.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_profile),
                            contentDescription = null,
                            modifier = Modifier
                                .size(140.dp)
                                .clip(CircleShape)
                        )
                        MediumSpacer()
                        Text(
                            text = "Jose Alejandro Ojalvo Prim",
                            style = MobileChallengeTypography.displaySmall,
                            textAlign = TextAlign.Center
                        )
                        ExtraSmallSpacer()
                        Text(
                            text = "Android Developer",
                            style = MobileChallengeTypography.headlineMedium,
                            textAlign = TextAlign.Center
                        )
                        ExtraSmallSpacer()
                        Text(
                            text = "Developed by @jojalvo",
                            style = MobileChallengeTypography.headlineMedium,
                            textAlign = TextAlign.Center
                        )
                        SmallSpacer()
                        ClickableText(
                            text = AnnotatedString(
                                text = stringResource(
                                    id = R.string.text_about_me_github
                                )
                            ),
                            style = MobileChallengeTypography.titleLarge,
                            onClick = {
                                uriHandler.openUri(githubLink)
                            }
                        )
                        SmallSpacer()
                        ClickableText(
                            text = AnnotatedString(
                                text = stringResource(
                                    id = R.string.text_about_me_linkedin
                                )
                            ),
                            style = MobileChallengeTypography.titleLarge,
                            onClick = {
                                uriHandler.openUri(linkedInLink)
                            }
                        )
                    }
                }
            }
        }
    )
}

@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Composable
fun AboutScreenPreview() {
    MobileChallengeTheme {
        Surface(modifier = Modifier.background(MobileChallengeColors.background)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                shape = MobileChallengeShapes.medium,
                elevation = CardDefaults.elevatedCardElevation()
            ) {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(12.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = null,
                        modifier = Modifier
                            .size(140.dp)
                            .clip(CircleShape)
                    )
                    MediumSpacer()
                    Text(
                        text = "Jose Alejandro Ojalvo Prim",
                        style = MobileChallengeTypography.displaySmall,
                        textAlign = TextAlign.Center
                    )
                    ExtraSmallSpacer()
                    Text(
                        text = "Android Developer",
                        style = MobileChallengeTypography.headlineMedium,
                        textAlign = TextAlign.Center
                    )
                    ExtraSmallSpacer()
                    Text(
                        text = "Developed by @jojalvo",
                        style = MobileChallengeTypography.headlineMedium,
                        textAlign = TextAlign.Center
                    )
                    SmallSpacer()
                    ClickableText(
                        text = AnnotatedString(
                            text = stringResource(
                                id = R.string.text_about_me_github
                            )
                        ),
                        style = MobileChallengeTypography.titleLarge,
                        onClick = {}
                    )
                    SmallSpacer()
                    ClickableText(
                        text = AnnotatedString(
                            text = stringResource(
                                id = R.string.text_about_me_linkedin
                            )
                        ),
                        style = MobileChallengeTypography.titleLarge,
                        onClick = {}
                    )
                }
            }
        }
    }
}