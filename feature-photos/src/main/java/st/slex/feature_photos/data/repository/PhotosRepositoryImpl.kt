package st.slex.feature_photos.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow
import st.slex.feature_photos.ui.model.PhotoUIModel
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val pagingSource: PagingSource<Int, PhotoUIModel>
) : PhotosRepository {

    private val pagingConfig: PagingConfig by lazy {
        PagingConfig(pageSize = 10, enablePlaceholders = false)
    }

    private val pager: Pager<Int, PhotoUIModel> by lazy {
        Pager(
            pagingConfig,
            pagingSourceFactory = { pagingSource }
        )
    }

    override fun invoke(): Flow<PagingData<PhotoUIModel>> = pager.flow
}