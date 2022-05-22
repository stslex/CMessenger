package st.slex.feature_photos.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import st.slex.core_ui.theme.AppBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotosScreen(
    windowSizeClass: WindowSizeClass,
    modifier: Modifier = Modifier,
    viewModel: PhotosViewModel = hiltViewModel()
) {
    val photosLazyPagingItems = viewModel.photos.collectAsLazyPagingItems()

    AppBackground {
        Scaffold(modifier = modifier.windowInsetsPadding(WindowInsets.safeDrawing)) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(photosLazyPagingItems) { image ->
                    println("Photos:: " + image?.urls?.regular)
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(image?.urls?.regular)
                            .crossfade(true)
                            .transformations(RoundedCornersTransformation(20f))
                            .build(),
                        contentDescription = "Description",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.padding(20.dp)
                    )
                }
            }
        }
    }

}
