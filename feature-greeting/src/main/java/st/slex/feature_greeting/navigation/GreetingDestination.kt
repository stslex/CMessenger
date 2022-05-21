package st.slex.feature_greeting.navigation

import st.slex.core_navigation.AppNavigationDestination

object GreetingDestination : AppNavigationDestination {

    override val route
        get() = "greeting_route"

    override val destination
        get() = "greeting_destination"
}