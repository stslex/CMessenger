package st.slex.feature_collections.navigation

import st.slex.core_navigation.AppNavigationDestination

object CollectionsDestination : AppNavigationDestination {

    override val route: String
        get() = "collections_route"

    override val destination: String
        get() = "collections_destination"
}