package st.slex.feature_photos.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import st.slex.core_model.ui.PhotoUIModel

interface PhotosRepository {
    fun setUpQuery(queryString: String)
    operator fun invoke(): Flow<PagingData<PhotoUIModel>>
}
