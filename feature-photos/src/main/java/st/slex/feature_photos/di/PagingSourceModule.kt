package st.slex.feature_photos.di

import androidx.paging.PagingSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import st.slex.feature_photos.data.paging_source.PhotosPagingSource
import st.slex.feature_photos.data.service.PhotosService
import st.slex.core_model.mapper.MapperPhotoDataUI
import st.slex.core_model.ui.PhotoUIModel

@Module
@InstallIn(SingletonComponent::class)
class PagingSourceModule {

    @Provides
    fun providesPhotosPagingSource(
        service: PhotosService,
        mapper: MapperPhotoDataUI
    ): PagingSource<Int, PhotoUIModel> = PhotosPagingSource(service = service, mapper = mapper)
}