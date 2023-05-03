@file:OptIn(ExperimentalPagerApi::class)

package com.jojalvo.onboarding

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.*
import com.jojalvo.theme.*
import com.jojalvo.theme.R
import com.jojalvo.utils.extension.getActivity
import com.jojalvo.utils.extension.launchActivity

/**
 *   @author jojalvo
 *   @since 17/4/23
 *   @email josealejandro025@gmail.com
 */
@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(viewModel: OnBoardingViewModel = hiltViewModel()) {

    val context = LocalContext.current
    val pages = listOf(
        OnBoardingPage.First(context),
        OnBoardingPage.Second(context),
        OnBoardingPage.Third(context)
    )
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MobileChallengeColors.primary)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            count = pages.count(),
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoarding = pages[position], context)
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f),
            pagerState = pagerState,
            activeColor = colorResource(R.color.red_primary_dark)
        )
        FinishButton(
            modifier = Modifier.weight(1f),
            pagerState = pagerState
        ) {
            viewModel.saveOnBoardingState(completed = true)
            context.getActivity()?.run {
                launchActivity(
                    packageName = context.packageName,
                    className = "com.jojalvo.mcapp.navigation.MainActivity"
                ).also {
                    finish()
                }
            }
        }
    }
}

@Composable
fun PagerScreen(onBoarding: OnBoardingPage, context: Context) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(.7f)
                .fillMaxHeight(.7f),
            painter = painterResource(id = onBoarding.image),
            contentDescription = context.getString(R.string.on_boarding_image_content_description)
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = onBoarding.title,
            textAlign = TextAlign.Center,
            fontSize = MobileChallengeTypography.displayMedium.fontSize,
            fontWeight = FontWeight.Bold,
            color = MobileChallengeColors.onTertiary
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .padding(top = 20.dp),
            text = onBoarding.description,
            textAlign = TextAlign.Center,
            fontSize = MobileChallengeTypography.headlineMedium.fontSize,
            fontWeight = FontWeight.Medium,
            color = MobileChallengeColors.onTertiary
        )
    }
}

@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = 40.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 2
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Red700
                ),
                shape = RectangleShape
            ) {
                Text(
                    text = stringResource(id = R.string.text_finish),
                    color = White,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun OnBoardingPreview() {
    MobileChallengeTheme {
        OnBoardingScreen()
    }
}