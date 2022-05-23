package st.slex.feature_photos.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import retrofit2.HttpException
import st.slex.core_model.data.PhotoDataModel
import st.slex.core_model.mapper.MapperPhotoDataUI
import st.slex.core_model.ui.PhotoUIModel
import st.slex.feature_photos.data.service.PhotosService

class PhotosPagingSource @AssistedInject constructor(
    private val service: PhotosService,
    private val mapper: MapperPhotoDataUI,
    @Assisted("query") private val query: String
) : PagingSource<Int, PhotoUIModel>() {

    override fun getRefreshKey(state: PagingState<Int, PhotoUIModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotoUIModel> {
        try {
            val pageNumber = params.key ?: INITIAL_PAGE_NUMBER
            val pageSize = params.loadSize

            val photos: List<PhotoDataModel> = if (query.isEmpty()) {
                val response = service.getPhotos(
                    page = pageNumber,
                    page_size = pageSize
                )
                if (response.isSuccessful) response.body()!!
                else return LoadResult.Error(HttpException(response))
            } else {
                val response = service.getSearchPhotos(
                    page = pageNumber,
                    page_size = pageSize,
                    query = query
                )
                if (response.isSuccessful) response.body()!!.results
                else return LoadResult.Error(HttpException(response))
            }

            val resultPhotos = photos.map(mapper::map)
            val nextPageNumber = if (resultPhotos.isEmpty()) null else pageNumber + 1
            val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null
            return LoadResult.Page(resultPhotos, prevPageNumber, nextPageNumber)
        } catch (httpException: HttpException) {
            return LoadResult.Error(httpException)
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val INITIAL_PAGE_NUMBER = 1
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted("query") query: String): PhotosPagingSource
    }
}