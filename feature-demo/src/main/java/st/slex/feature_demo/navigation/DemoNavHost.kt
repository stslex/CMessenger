package st.slex.feature_demo.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import st.slex.feature_collections.navigation.collectionsGraph
import st.slex.feature_photos.navigation.PhotosDestination
import st.slex.feature_photos.navigation.photosGraph

@Composable
fun DemoNavHost(
    windowSizeClass: WindowSizeClass,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = PhotosDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        photosGraph(windowSizeClass = windowSizeClass)
        collectionsGraph(windowSizeClass = windowSizeClass)
    }
}