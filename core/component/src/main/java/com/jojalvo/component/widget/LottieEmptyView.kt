package com.jojalvo.component.widget

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jojalvo.component.LottieView
import com.jojalvo.theme.MobileChallengeColors
import com.jojalvo.theme.MobileChallengeTheme
import com.jojalvo.theme.MobileChallengeTypography
import com.jojalvo.theme.R

/**
 *   @author jojalvo
 *   @since 3/5/23
 *   @email josealejandro025@gmail.com
 */
@Composable
fun LottieEmptyView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize().background(MobileChallengeColors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieView(
            file = "empty.json",
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Text(
            text = stringResource(id = R.string.text_no_data_found),
            style = MobileChallengeTypography.displaySmall,
            textAlign = TextAlign.Center,
            color = MobileChallengeColors.onTertiary,
            modifier = modifier
                .fillMaxWidth()
        )
    }
}

@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun LottieEmptyViewPreview() {
    MobileChallengeTheme {
        LottieEmptyView()
    }
}