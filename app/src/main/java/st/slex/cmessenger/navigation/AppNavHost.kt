package st.slex.cmessenger.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import st.slex.feature_auth.navigation.AuthDestination
import st.slex.feature_auth.navigation.authGraph
import st.slex.feature_demo.DemoActivity
import st.slex.feature_greeting.navigation.GreetingDestination
import st.slex.feature_greeting.navigation.greetingGraph

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = GreetingDestination.route,
        modifier = modifier,
    ) {
        greetingGraph(navigateToAuth = { navController.navigate(AuthDestination.route) },
            navigateToDemo = {
                context.startActivity(Intent(context, DemoActivity::class.java))
            })
        authGraph(onBackClick = { navController.popBackStack() })
    }
}