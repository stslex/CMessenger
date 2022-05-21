package st.slex.feature_greeting.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import st.slex.feature_greeting.ui.GreetingScreen

@Composable
fun GreetingRoute(
    navigateToAuth: () -> Unit,
    navigateToDemo: () -> Unit,
    modifier: Modifier = Modifier
) {
    GreetingScreen(modifier, navigateToAuth, navigateToDemo)
}