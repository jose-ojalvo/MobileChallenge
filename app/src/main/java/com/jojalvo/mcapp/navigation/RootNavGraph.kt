package com.jojalvo.mcapp.navigation

import com.jojalvo.home.HomeNavGraph
import com.jojalvo.settings.SettingsNavGraph
import com.jojalvo.users.detail.UsersNavGraph
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec

/**
 *   @author jojalvo
 *   @since 20/4/23
 *   @email josealejandro025@gmail.com
 */
object RootNavGraph : NavGraphSpec {
    override val route = "root"

    override val startRoute = HomeNavGraph

    override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()

    override val nestedNavGraphs = listOf(
        HomeNavGraph,
        UsersNavGraph,
        SettingsNavGraph
    )
}