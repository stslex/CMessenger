package st.slex.feature_auth.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(
    modifier: Modifier = Modifier
) {

    LazyColumn {
        item {
            Spacer(
                Modifier.windowInsetsPadding(
                    WindowInsets.safeDrawing.only(WindowInsetsSides.Top)
                )
            )
        }
        item {
            ElevatedCard(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .clickable {

                    },
            ) {
                Text(
                    modifier = Modifier
                        .padding(20.dp)
                        .align(Alignment.CenterHorizontally),
                    text = "Text",
                    style = MaterialTheme.typography.displayLarge,
                    fontSize = 40.sp
                )
            }
        }
        item {
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp).clickable {

                    },
                colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Text(
                    modifier = Modifier
                        .padding(20.dp)
                        .align(Alignment.CenterHorizontally),
                    text = "Text",
                    style = MaterialTheme.typography.displayLarge,
                    fontSize = 40.sp
                )
            }
        }
        item {
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .clickable {

                    },
                colors = CardDefaults.outlinedCardColors(containerColor = MaterialTheme.colorScheme.surface)
            ) {
                Text(
                    modifier = Modifier
                        .padding(20.dp)
                        .align(Alignment.CenterHorizontally),
                    text = "Text",
                    style = MaterialTheme.typography.displayLarge,
                    fontSize = 40.sp
                )
            }
        }
        item {
            Spacer(
                Modifier.windowInsetsPadding(
                    WindowInsets.safeDrawing.only(WindowInsetsSides.Bottom)
                )
            )
        }
    }
}