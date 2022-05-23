package st.slex.feature_photos.data.repository

import androidx.paging.PagingSource
import st.slex.core_model.ui.PhotoUIModel
import st.slex.feature_photos.data.paging_source.PhotosPagingSource
import javax.inject.Inject

interface PhotosRepository {

    operator fun invoke(query: String): PagingSource<Int, PhotoUIModel>

    class Base @Inject constructor(
        private val photosPagingSourceFactory: PhotosPagingSource.Factory
    ) : PhotosRepository {

        override fun invoke(query: String): PagingSource<Int, PhotoUIModel> =
            photosPagingSourceFactory.create(query)
    }
}
