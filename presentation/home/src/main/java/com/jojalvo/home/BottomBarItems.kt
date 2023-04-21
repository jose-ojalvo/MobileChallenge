package com.jojalvo.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.jojalvo.theme.R

/**
 *   @author jojalvo
 *   @since 21/4/23
 *   @email josealejandro025@gmail.com
 */
enum class BottomBarItems(
    @StringRes val title: Int,
    val icon: ImageVector
) {
    HOME(
        title = R.string.bottom_menu_home,
        icon = Icons.Filled.AddHome
    ),
    FAV(
        title = R.string.bottom_menu_fav,
        icon = Icons.Filled.Star
    ),
    SETTINGS(
        title = R.string.bottom_menu_settings,
        icon = Icons.Filled.Settings
    )
}