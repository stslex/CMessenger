package st.slex.feature_photos.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import st.slex.feature_photos.ui.model.PhotoUIModel
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val pagingSource: PagingSource<Int, PhotoUIModel>
) : ViewModel() {

    private val newPager: Pager<Int, PhotoUIModel> by lazy {
        Pager(PagingConfig(pageSize = 10, enablePlaceholders = false)) {
            pagingSource
        }
    }

    val photos: StateFlow<PagingData<PhotoUIModel>> = newPager.flow
        .cachedIn(viewModelScope)
        .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
}