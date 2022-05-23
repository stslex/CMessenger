package st.slex.feature_photos.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import st.slex.core_model.ui.PhotoUIModel
import javax.inject.Inject
import javax.inject.Provider

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val queryPhotosUseCase: Provider<QueryPhotosUseCase>
) : ViewModel() {

    private val _querySearch: MutableStateFlow<String> = MutableStateFlow("")
    private val querySearch: StateFlow<String>
        get() = _querySearch.asStateFlow()

    val photos: StateFlow<PagingData<PhotoUIModel>> = querySearch
        .map(::newPagerPhotosSearch)
        .flatMapLatest { pager -> pager.flow }
        .cachedIn(viewModelScope)
        .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())

    private fun newPagerPhotosSearch(query: String): Pager<Int, PhotoUIModel> {
        return Pager(PagingConfig(5, enablePlaceholders = false)) {
            newPagingPhotosSearchSource?.invalidate()
            val queryPhotosUseCase = queryPhotosUseCase.get()
            queryPhotosUseCase(query).also { newPagingPhotosSearchSource = it }
        }
    }

    fun setQueryPhotosSearch(query: String) {
        _querySearch.tryEmit(query)
    }

    private var newPagingPhotosSearchSource: PagingSource<*, *>? = null
}