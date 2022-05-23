package st.slex.feature_demo.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import st.slex.core_navigation.TopLevelDestination
import st.slex.core_ui.components.AppBackground
import st.slex.core_ui.theme.CMessengerTheme
import st.slex.core_ui.components.ClearRippleTheme
import st.slex.feature_demo.navigation.AppTopLevelNavigation
import st.slex.feature_demo.navigation.DemoNavHost
import st.slex.feature_demo.navigation.TOP_LEVEL_DESTINATIONS

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun DemoCreator(windowSizeClass: WindowSizeClass) {
    CMessengerTheme(dynamicColor = true) {
        val navController = rememberNavController()
        val niaTopLevelNavigation = remember(navController) {
            AppTopLevelNavigation(navController)
        }

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        AppBackground {
            Scaffold(
                modifier = Modifier,
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onBackground,
                bottomBar = {
                    if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
                        DemoBottomBar(
                            onNavigateToTopLevelDestination = niaTopLevelNavigation::navigateTo,
                            currentDestination = currentDestination
                        )
                    }
                }
            ) { padding ->
                Row(
                    Modifier
                        .fillMaxSize()
                        .windowInsetsPadding(
                            WindowInsets.safeDrawing.only(
                                WindowInsetsSides.Horizontal
                            )
                        )
                ) {
                    if (windowSizeClass.widthSizeClass != WindowWidthSizeClass.Compact) {
                        NiANavRail(
                            onNavigateToTopLevelDestination = niaTopLevelNavigation::navigateTo,
                            currentDestination = currentDestination,
                            modifier = Modifier.safeDrawingPadding()
                        )
                    }

                    DemoNavHost(
                        windowSizeClass = windowSizeClass,
                        navController = navController,
                        modifier = Modifier
                            .padding(padding)
                            .consumedWindowInsets(padding)
                    )
                }
            }
        }
    }
}

@Composable
private fun NiANavRail(
    onNavigateToTopLevelDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
) {
    NavigationRail(modifier = modifier) {
        TOP_LEVEL_DESTINATIONS.forEach { destination ->
            val selected =
                currentDestination?.hierarchy?.any { it.route == destination.route } == true
            NavigationRailItem(
                selected = selected,
                onClick = { onNavigateToTopLevelDestination(destination) },
                icon = {
                    Icon(
                        if (selected) destination.selectedIcon else destination.unselectedIcon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(destination.iconTextId))
                },
                alwaysShowLabel = false
            )
        }
    }
}

@Composable
private fun DemoBottomBar(
    onNavigateToTopLevelDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    Surface(color = MaterialTheme.colorScheme.surface) {
        CompositionLocalProvider(LocalRippleTheme provides ClearRippleTheme) {
            NavigationBar(
                modifier = Modifier.windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom
                    )
                ),
                tonalElevation = 0.dp
            ) {

                TOP_LEVEL_DESTINATIONS.forEach { destination ->
                    val selected =
                        currentDestination?.hierarchy?.any { it.route == destination.route } == true
                    NavigationBarItem(
                        selected = selected,
                        onClick = { onNavigateToTopLevelDestination(destination) },
                        icon = {
                            Icon(
                                if (selected) {
                                    destination.selectedIcon
                                } else {
                                    destination.unselectedIcon
                                },
                                contentDescription = null
                            )
                        },
                        label = { Text(stringResource(destination.iconTextId)) },
                        alwaysShowLabel = false
                    )
                }
            }
        }
    }
}