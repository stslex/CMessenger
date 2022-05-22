package st.slex.feature_photos.data.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import st.slex.feature_photos.ui.model.PhotoUIModel

interface PhotosRepository {
    operator fun invoke(): Flow<PagingData<PhotoUIModel>>
}
