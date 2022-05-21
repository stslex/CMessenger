package st.slex.feature_greeting.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.greetingGraph(
    navigateToAuth: () -> Unit, navigateToDemo: () -> Unit
) {
    composable(route = GreetingDestination.route) {
        GreetingRoute(navigateToAuth = navigateToAuth, navigateToDemo = navigateToDemo)
    }
}