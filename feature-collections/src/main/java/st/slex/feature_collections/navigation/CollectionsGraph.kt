package st.slex.feature_collections.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import st.slex.feature_collections.ui.CollectionsRoute

fun NavGraphBuilder.collectionsGraph(
    windowSizeClass: WindowSizeClass
) {
    composable(route = CollectionsDestination.route) {
        CollectionsRoute(windowSizeClass = windowSizeClass)
    }
}