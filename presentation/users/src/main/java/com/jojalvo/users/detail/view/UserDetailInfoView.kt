package com.jojalvo.users.detail.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.jojalvo.component.widget.MCDivider
import com.jojalvo.entity.user.Result
import com.jojalvo.theme.MobileChallengeColors
import com.jojalvo.theme.MobileChallengeTypography
import com.jojalvo.theme.R
import com.jojalvo.utils.extension.getFullName
import com.jojalvo.utils.extension.safeNull

/**
 *   @author jojalvo
 *   @since 1/5/23
 *   @email josealejandro025@gmail.com
 */
@Composable
fun UserDetailInfoView(data: Result) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.text_information),
            modifier = Modifier
                .padding(12.dp),
            style = MobileChallengeTypography.titleLarge
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MobileChallengeColors.surface),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                TextRow(
                    key = stringResource(id = R.string.text_name),
                    value = data.name?.getFullName().safeNull()
                )

                MCDivider()

                TextRow(
                    key = stringResource(id = R.string.text_email),
                    value = data.email
                )

                MCDivider()

                TextRow(
                    key = stringResource(id = R.string.text_country),
                    value = data.location?.country.safeNull()
                )

                MCDivider()

                TextRow(
                    key = stringResource(id = R.string.text_city),
                    value = data.location?.city.safeNull()
                )

                MCDivider()

                TextRow(
                    key = stringResource(id = R.string.text_phone),
                    value = data.phone
                )
            }
        }
    }
}

@Composable
private fun TextRow(key: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = key,
            maxLines = 1,
            overflow = TextOverflow.Visible,
            style = MobileChallengeTypography.bodyMedium,
            textAlign = TextAlign.Start
        )
        Text(
            text = value,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MobileChallengeTypography.titleMedium,
            textAlign = TextAlign.End
        )
    }
}