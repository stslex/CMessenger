package st.slex.cmessenger.navigation

import android.app.Activity
import android.view.View
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.core.view.doOnPreDraw
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import st.slex.feature_auth.navigation.AuthDestination
import st.slex.feature_auth.navigation.authGraph

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    windowSizeClass: WindowSizeClass,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AuthDestination.route,
        modifier = modifier,
    ) {
        authGraph(
            onBackClick = { navController.popBackStack() }
        )
    }
}

@Composable
private fun ReportFullyDrawn(destination: String) {
    val localView: View = LocalView.current
    (localView.context as? Activity)?.run {
        localView.doOnPreDraw {
            reportFullyDrawn()
        }
    }
}