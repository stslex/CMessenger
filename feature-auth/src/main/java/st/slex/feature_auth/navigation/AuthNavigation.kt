package st.slex.feature_auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import st.slex.core_navigation.AppNavigationDestination
import st.slex.feature_auth.AuthRoute

object AuthDestination : AppNavigationDestination {
    override val route = "auth_route"
    override val destination = "auth_destination"
}

fun NavGraphBuilder.authGraph(
    onBackClick: () -> Unit
) {
    composable(route = AuthDestination.route) {
        AuthRoute(onBackClick = onBackClick)
    }
}