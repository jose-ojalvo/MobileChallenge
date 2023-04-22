package com.jojalvo.component.widget

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jojalvo.theme.R
import com.jojalvo.theme.MobileChallengeColors
import com.jojalvo.theme.MobileChallengeTypography

/**
 *   @author jojalvo
 *   @since 22/4/23
 *   @email josealejandro025@gmail.com
 */
@Composable
fun MCToolbar(
    @StringRes titleString: Int,
    elevation: Dp = AppBarDefaults.TopAppBarElevation
) {
    TopAppBar(
        title = {
            Text(
                stringResource(id = titleString),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = MobileChallengeTypography.displayMedium
            )
        },
        backgroundColor = MobileChallengeColors.primary,
        modifier = Modifier.fillMaxWidth(),
        elevation = elevation
    )
}

@Composable
fun MCToolbarWithNavIcon(
    @StringRes titleResId: Int,
    pressOnBack: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                stringResource(titleResId),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(),
                style = MobileChallengeTypography.displayMedium
            )
        },
        navigationIcon = {
            Icon(
                rememberVectorPainter(Icons.Filled.ArrowBack),
                contentDescription = stringResource(id = R.string.toolbar_navigation_back_button),
                tint = MobileChallengeColors.onTertiary,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { pressOnBack.invoke() }
            )
        },
        backgroundColor = MobileChallengeColors.primary,
        modifier = Modifier.fillMaxWidth()
    )
}