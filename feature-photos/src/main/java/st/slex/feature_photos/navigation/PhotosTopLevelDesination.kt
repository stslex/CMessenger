package st.slex.feature_photos.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material.icons.outlined.PhotoLibrary
import st.slex.core_navigation.TopLevelDestination
import st.slex.feature_photos.R

val PHOTOS_TOP_LEVEL_DESTINATION = TopLevelDestination(
    route = PhotosDestination.route,
    selectedIcon = Icons.Filled.PhotoLibrary,
    unselectedIcon = Icons.Outlined.PhotoLibrary,
    iconTextId = R.string.photos_label
)