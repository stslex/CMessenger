package st.slex.feature_photos.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import st.slex.core_ui.components.AppBackground
import st.slex.core_ui.components.ImagePreview

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
                    ImagePreview(url = image?.urls?.regular.orEmpty()) {}
                }
            }
        }
    }
}
