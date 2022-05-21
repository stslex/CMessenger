package st.slex.feature_photos.navigation

import st.slex.core_navigation.AppNavigationDestination

object PhotosDestination : AppNavigationDestination {

    override val route: String
        get() = "photos_route"

    override val destination: String
        get() = "photos_destination"
}