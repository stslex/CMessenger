package st.slex.core_ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ImagePreview(url: String, onClickAction: () -> Unit) {
    GlideImage(
        modifier = Modifier
            .padding(20.dp)
            .shadow(
                elevation = 20.dp,
                shape = RoundedCornerShape(20.dp),
                clip = true,
                ambientColor = MaterialTheme.colorScheme.surface,
                spotColor = MaterialTheme.colorScheme.surface
            )
            .clickable(onClick = onClickAction),
        imageModel = url,
        contentScale = ContentScale.Crop,
        requestOptions = {
            RequestOptions().diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        },
        alignment = Alignment.Center,
        circularReveal = CircularReveal(duration = 1000),
        placeHolder = ImageBitmap(
            100,
            200,
            colorSpace = MaterialTheme.colorScheme.surface.colorSpace
        )
    )
}