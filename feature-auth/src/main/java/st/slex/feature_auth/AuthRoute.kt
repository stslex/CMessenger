package st.slex.feature_auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthRoute(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    AuthScreen(modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(
    modifier: Modifier = Modifier,
    lazyListState: LazyListState = rememberLazyListState()
) {
    Column(modifier = modifier.fillMaxSize()) {
        OutlinedCard(
            Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(20.dp)
                    .align(Alignment.CenterHorizontally),
                text = "${lazyListState.firstVisibleItemIndex}",
                style = MaterialTheme.typography.labelLarge,
                fontSize = 40.sp
            )
        }

        OutlinedCard(
            Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            LazyColumn(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                state = lazyListState,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(100) { position ->
                    Text(text = "Position:: $position")
                }
            }
        }


    }
}