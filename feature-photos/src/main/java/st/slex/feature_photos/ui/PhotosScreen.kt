package st.slex.feature_photos.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import st.slex.core_demo_ui.ImagePreview
import st.slex.core_ui.components.AppBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotosScreen(
    windowSizeClass: WindowSizeClass,
    modifier: Modifier = Modifier,
    viewModel: PhotosViewModel = hiltViewModel()
) {
    val photosLazyPagingItems = viewModel.photos.collectAsLazyPagingItems()
    AppBackground {
        Scaffold(
            modifier = modifier.windowInsetsPadding(WindowInsets.safeDrawing),
            topBar = { TopSearchBar(viewModel::setQueryPhotosSearch) }
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(photosLazyPagingItems) { image ->
                    ImagePreview(url = image?.urls?.regular.orEmpty()) {}
                }
            }
        }
    }
}

@Composable
fun TopSearchBar(search: (String) -> Unit) {
    var textInput by remember { mutableStateOf("") }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(bottom = 20.dp),
        value = textInput,
        onValueChange = {
            textInput = it
            search(it)
        })
}
