package st.slex.feature_photos.data.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import st.slex.feature_photos.BuildConfig
import st.slex.feature_photos.data.core.Constants.GET_PHOTOS
import st.slex.feature_photos.data.core.Constants.QUERY_API_KEY
import st.slex.feature_photos.data.core.Constants.QUERY_PAGE
import st.slex.feature_photos.data.core.Constants.QUERY_PAGE_SIZE
import st.slex.core_model.data.PhotoDataModel

interface PhotosService {

    @GET(GET_PHOTOS)
    suspend fun getPhotos(
        @Query(QUERY_PAGE) page: Int,
        @Query(QUERY_PAGE_SIZE) page_size: Int,
        @Query(QUERY_API_KEY) api_key: String = BuildConfig.API_KEY
    ): Response<List<PhotoDataModel>>
}