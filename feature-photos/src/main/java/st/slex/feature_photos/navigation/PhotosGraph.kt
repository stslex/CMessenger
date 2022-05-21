package st.slex.feature_photos.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import st.slex.feature_photos.ui.PhotosRoute

fun NavGraphBuilder.photosGraph(
    windowSizeClass: WindowSizeClass
) {
    composable(route = PhotosDestination.route) {
        PhotosRoute(windowSizeClass = windowSizeClass)
    }
}