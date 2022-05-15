package st.slex.feature_auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import st.slex.feature_auth.ui.AuthScreen

@Composable
fun AuthRoute(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    AuthScreen(modifier)
}