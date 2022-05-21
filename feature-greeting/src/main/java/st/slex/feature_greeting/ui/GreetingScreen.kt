package st.slex.feature_greeting.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import st.slex.Loading
import st.slex.core_ui.theme.CMessengerTheme

@Composable
fun GreetingScreen(
    modifier: Modifier = Modifier, navigateToAuth: () -> Unit, navigateToDemo: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {
        Loading(Modifier.align(Alignment.TopCenter))
        Loading(Modifier.align(Alignment.BottomCenter))
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(40.dp)
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = navigateToDemo,
                content = buttonText("Demo")
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp),
                onClick = navigateToAuth,
                content = buttonText("Auth")
            )
        }
    }
}

fun buttonText(text: String): @Composable (RowScope.() -> Unit) = {
    Text(
        modifier = Modifier.padding(0.dp),
        text = text,
        style = MaterialTheme.typography.displayMedium
    )
}

@Preview(device = "id:pixel_4", showSystemUi = true, showBackground = true)
@Composable
fun GreetingScreenPreview() {
    CMessengerTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            GreetingScreen(navigateToAuth = {}, navigateToDemo = {})
        }
    }
}