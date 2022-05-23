package st.slex.feature_photos.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.*
import st.slex.core_model.ui.PhotoUIModel
import st.slex.feature_photos.data.paging_source.PhotosPagingSource
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val pagingSourceFactory: PhotosPagingSource.Factory
) : PhotosRepository {

    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    private val query: StateFlow<String>
        get() = _query.asStateFlow()

    override fun setUpQuery(queryString: String) {
        _query.tryEmit(queryString)
    }

    private val pagingConfig: PagingConfig by lazy {
        PagingConfig(pageSize = 10, enablePlaceholders = false)
    }

    override fun invoke(): Flow<PagingData<PhotoUIModel>> = query.map(::newPager)
        .flatMapLatest { it.flow }

    private fun newPager(query: String): Pager<Int, PhotoUIModel> = Pager(
        pagingConfig,
        pagingSourceFactory = { pagingSourceFactory.create(query) }
    )
}