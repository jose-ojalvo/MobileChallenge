package com.jojalvo.framework.base.jetpack

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController

/**
 *   @author jojalvo
 *   @since 18/4/23
 *   @email josealejandro025@gmail.com
 */
@Composable
fun SetupSystemUi(
    systemUiController: SystemUiController,
    systemColor: Color
) {
    SideEffect {
        systemUiController.setSystemBarsColor(color = systemColor)
    }
}