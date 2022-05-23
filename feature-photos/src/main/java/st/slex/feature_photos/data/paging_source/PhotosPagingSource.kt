package st.slex.feature_photos.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import st.slex.feature_photos.data.service.PhotosService
import st.slex.core_model.mapper.MapperPhotoDataUI
import st.slex.core_model.ui.PhotoUIModel
import javax.inject.Inject

class PhotosPagingSource @Inject constructor(
    private val service: PhotosService,
    private val mapper: MapperPhotoDataUI
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

            val response = service.getPhotos(page = pageNumber, page_size = pageSize)

            return if (response.isSuccessful) {
                val photos = response.body()!!.map(mapper::map)
                val nextPageNumber = if (photos.isEmpty()) null else pageNumber + 1
                val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null
                LoadResult.Page(photos, prevPageNumber, nextPageNumber)
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (httpException: HttpException) {
            return LoadResult.Error(httpException)
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val INITIAL_PAGE_NUMBER = 1
    }
}