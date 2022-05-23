package st.slex.feature_photos.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    val query: MutableState<String> = remember { mutableStateOf("") }
    val photosLazyPagingItems = viewModel.photos.collectAsLazyPagingItems()
    //viewModel.setUpQuery(query.value)
    AppBackground {
        Scaffold(
            modifier = modifier.windowInsetsPadding(WindowInsets.safeDrawing)
            //topBar = { TopSearchBar(query) }
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
fun TopSearchBar(query: MutableState<String>) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(bottom = 20.dp),
        value = query.value,
        onValueChange = {
            query.value = it
        })
}
