package st.slex.feature_photos.ui

import androidx.paging.PagingSource
import st.slex.core_model.ui.PhotoUIModel
import st.slex.feature_photos.data.repository.PhotosRepository
import javax.inject.Inject

class QueryPhotosUseCase @Inject constructor(
    private val repository: PhotosRepository
) {

    operator fun invoke(query: String): PagingSource<Int, PhotoUIModel> {
        return repository.invoke(query = query)
    }
}