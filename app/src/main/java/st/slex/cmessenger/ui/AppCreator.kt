package st.slex.cmessenger.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import st.slex.cmessenger.navigation.AppNavHost
import st.slex.core_ui.theme.CMessengerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppCreator(windowSizeClass: WindowSizeClass) {
    CMessengerTheme(dynamicColor = true) {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { padding ->
            AppNavHost(
                modifier = Modifier.padding(padding),
                windowSizeClass = windowSizeClass,
                navController = navController
            )
        }
    }
}