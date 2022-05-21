package st.slex.feature_collections.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CollectionsBookmark
import androidx.compose.material.icons.outlined.CollectionsBookmark
import st.slex.core_navigation.TopLevelDestination
import st.slex.feature_collections.R

val COLLECTIONS_TOP_LEVEL_DESTINATION = TopLevelDestination(
    route = CollectionsDestination.route,
    selectedIcon = Icons.Filled.CollectionsBookmark,
    unselectedIcon = Icons.Outlined.CollectionsBookmark,
    iconTextId = R.string.collections_label
)