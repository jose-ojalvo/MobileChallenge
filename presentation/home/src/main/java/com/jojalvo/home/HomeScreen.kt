package com.jojalvo.home

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jojalvo.home.BottomBarItem.HOME
import com.jojalvo.home.BottomBarItem.FAV
import com.jojalvo.home.BottomBarItem.SETTINGS
import com.google.accompanist.insets.navigationBarsHeight
import com.jojalvo.provider.NavigationProvider
import com.jojalvo.theme.MobileChallengeColors
import com.jojalvo.theme.RobotoFonts
import com.jojalvo.theme.selectedBottomItemColor
import com.jojalvo.theme.unselectedBottomItemColor
import com.ramcosta.composedestinations.annotation.Destination

/**
 *   @author jojalvo
 *   @since 20/4/23
 *   @email josealejandro025@gmail.com
 */
@Destination(start = true)
@Composable
fun HomeScreen(navigator: NavigationProvider) {
    val scaffoldState = rememberScaffoldState()
    val (currentBottomTab, setCurrentBottomTab) = rememberSaveable {
        mutableStateOf(HOME)
    }

    Crossfade(currentBottomTab) { bottomItem ->
        Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = { HomeBottomNavigation(bottomItem, setCurrentBottomTab) },
            content = {
                val modifier = Modifier
                    .padding(it)
                    .background(MobileChallengeColors.background)
                when (bottomItem) {
                    HOME -> Unit
                    FAV -> Unit
                    SETTINGS -> Unit
                }
            }
        )
    }

}

@Composable
fun HomeBottomNavigation(
    bottomTab: BottomBarItem,
    currentTab: (BottomBarItem) -> Unit
) {
    val bottomBarHeight = 50.dp
    val pages = BottomBarItem.values()

    BottomNavigation(
        backgroundColor = MobileChallengeColors.primary,
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsHeight(bottomBarHeight)
    ) {
        pages.forEach { page ->
            val selected = page == bottomTab
            val selectedItemColor = if (selected) {
                selectedBottomItemColor
            } else {
                unselectedBottomItemColor
            }
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = rememberVectorPainter(image = page.icon),
                        contentDescription = stringResource(id = page.title)
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = page.title),
                        color = selectedItemColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = RobotoFonts
                    )
                },
                selected = selected,
                onClick = { currentTab.invoke(page) },
                selectedContentColor = selectedBottomItemColor,
                unselectedContentColor = unselectedBottomItemColor,
                alwaysShowLabel = true,
                modifier = Modifier.navigationBarsPadding()
            )
        }
    }
}