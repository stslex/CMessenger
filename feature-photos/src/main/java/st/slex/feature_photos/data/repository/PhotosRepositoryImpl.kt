package st.slex.feature_photos.data.repository

import androidx.paging.PagingSource
import st.slex.feature_photos.ui.model.PhotoUIModel
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val pagingSource: PagingSource<Int, PhotoUIModel>
) : PhotosRepository {

    override fun query(): PagingSource<Int, PhotoUIModel> = pagingSource
}