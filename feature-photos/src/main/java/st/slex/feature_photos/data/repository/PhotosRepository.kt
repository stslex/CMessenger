package st.slex.feature_photos.data.repository

import androidx.paging.PagingSource
import st.slex.feature_photos.ui.model.PhotoUIModel

interface PhotosRepository {
    fun query(): PagingSource<Int, PhotoUIModel>
}
