package com.jojalvo.users.list.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jojalvo.constants.Constants.EMPTY_STRING
import com.jojalvo.entity.user.Result
import com.jojalvo.theme.MobileChallengeColors
import com.jojalvo.theme.MobileChallengeTypography
import com.jojalvo.users.list.viewmodel.UsersViewModel
import com.jojalvo.utils.extension.getNameSurname

/**
 *   @author jojalvo
 *   @since 30/4/23
 *   @email josealejandro025@gmail.com
 */
@Composable
fun UserRow(
    viewModel: UsersViewModel = hiltViewModel(),
    dto: Result,
    onDetailClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .clickable {
                onDetailClick()
            }
            .fillMaxWidth()
            .height(100.dp)
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            ),
        elevation = CardDefaults.elevatedCardElevation(),
        colors = CardDefaults.cardColors(
            containerColor = MobileChallengeColors.surface
        )
    ) {
        Row {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(dto.picture?.medium)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp)
                    .clip(RoundedCornerShape(size = 80.dp))
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 12.dp, start = 4.dp, bottom = 4.dp)
            ) {
                Text(
                    text = dto.name?.getNameSurname() ?: "John Doe",
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = MobileChallengeTypography.titleLarge
                )
                Text(
                    text = dto.location?.city ?: EMPTY_STRING,
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = MobileChallengeTypography.titleMedium
                )
                Text(
                    text = dto.phone,
                    modifier = Modifier
                        .fillMaxWidth(),
                    style = MobileChallengeTypography.titleMedium
                )
            }
        }
    }
}