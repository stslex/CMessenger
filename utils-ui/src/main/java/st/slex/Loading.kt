package st.slex

import android.content.res.Configuration
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import st.slex.core_ui.theme.CMessengerTheme
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Loading(modifier: Modifier = Modifier) {
    for (i in 0..5) {
        LoadingItem(modifier = modifier, initialState = i * 60.0)
    }
}

@Composable
fun LoadingItem(
    modifier: Modifier = Modifier, initialState: Double
) {
    var radian by remember { mutableStateOf(initialState) }
    val circleRadius = 30.0 * abs(cos(radian))
    val collapseRadius = 200.0 * abs(cos(radian))
    val circleColor = MaterialTheme.colorScheme.primary
    Canvas(modifier = modifier, onDraw = {
        val centerX = (collapseRadius * cos(radian)).toFloat()
        val centerY = (collapseRadius * sin(radian)).toFloat()
        val circleCenter = Offset(centerX, centerY)
        drawCircle(
            color = circleColor,
            radius = circleRadius.toFloat(),
            center = circleCenter,
            alpha = abs(0.7f * cos(radian).toFloat())
        )
    })
    LaunchedEffect(key1 = true) {
        while (true) {
            radian += 0.008
            radian %= 360
            delay(1)
        }
    }
}

@Preview(
    group = "tools",
    name = "Primary Loading",
    device = "id:pixel_4",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun LoadingPreview() {
    CMessengerTheme(dynamicColor = true) {
        Box(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
        ) {
            LazyColumn {
                items(100) {
                    Button(modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(), onClick = { }) {}
                }
            }
            Loading(Modifier.align(Alignment.Center))
        }
    }
}