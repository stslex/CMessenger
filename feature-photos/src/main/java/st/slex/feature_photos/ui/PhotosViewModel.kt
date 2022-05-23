package st.slex.feature_photos.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import st.slex.feature_photos.data.repository.PhotosRepository
import st.slex.core_model.ui.PhotoUIModel
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(photosRepository: PhotosRepository) : ViewModel() {

    val photos: StateFlow<PagingData<PhotoUIModel>> = photosRepository.invoke()
        .cachedIn(viewModelScope)
        .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
}