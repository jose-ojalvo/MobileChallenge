package com.jojalvo.users.detail.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.jojalvo.constants.Constants.EMPTY_STRING
import com.jojalvo.entity.user.Result

/**
 *   @author jojalvo
 *   @since 1/5/23
 *   @email josealejandro025@gmail.com
 */
@Composable
fun UserDetailContent(
    data: Result
) {
    LazyColumn {
        item("header") {
            UserDetailHeaderView(
                imageUrl = data.picture?.large ?: EMPTY_STRING
            )
        }

        item("contentInfo") {
            UserDetailInfoView(data = data)
        }
    }
}