package st.slex.feature_auth.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import st.slex.core_ui.theme.CMessengerTheme
import kotlin.math.absoluteValue

@Composable
fun Loading(
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current.density
    val configuration = LocalConfiguration.current
    val smallestScreenWidth = configuration.smallestScreenWidthDp * density
    val circleRadius = 20f
    val primaryAnchor = smallestScreenWidth / 2
    val stateX = remember { mutableStateOf(primaryAnchor) }
    val stateY = remember { mutableStateOf(primaryAnchor - primaryAnchor / 2) }
    val step = primaryAnchor / 20

    LaunchedEffect(key1 = true) {
        while (true) {
            if (stateX.value >= primaryAnchor && stateY.value <= primaryAnchor) {
                stateX.value = stateX.value + step
                stateY.value = stateY.value + step
            }
            if (stateX.value >= primaryAnchor && stateY.value >= primaryAnchor) {
                stateX.value = stateX.value - step
                stateY.value = stateY.value + step
            }
            if (stateX.value <= primaryAnchor && stateY.value >= primaryAnchor) {
                stateX.value = stateX.value - step
                stateY.value = stateY.value - step
            }
            if (stateX.value <= primaryAnchor && stateY.value <= primaryAnchor) {
                stateX.value = stateX.value + step
                stateY.value = stateY.value - step
            }
            delay(1)
        }

    }

    Canvas(
        modifier = modifier.size(smallestScreenWidth.dp),
        onDraw = {
            drawCircle(
                Brush.linearGradient(
                    colors = listOf(Color.Magenta, Color.Cyan)
                ),
                radius = circleRadius,
                center = Offset(stateX.value, stateY.value)
            )
        })
}

@Preview(
    group = "tools", name = "Primary Loading", device = "id:pixel_4", showBackground = true,
    showSystemUi = true
)
@Composable
fun LoadingPreview() {
    CMessengerTheme() {
        Loading()
    }
}