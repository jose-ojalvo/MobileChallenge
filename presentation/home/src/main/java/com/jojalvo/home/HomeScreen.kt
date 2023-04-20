package com.jojalvo.home

import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import com.jojalvo.provider.NavigationProvider
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


}