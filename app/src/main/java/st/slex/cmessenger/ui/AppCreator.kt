package st.slex.cmessenger.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import st.slex.cmessenger.navigation.AppNavHost
import st.slex.cmessenger.ui.theme.CMessengerTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun AppCreator(windowSizeClass: WindowSizeClass) {
    CMessengerTheme {
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