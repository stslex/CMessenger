package st.slex.feature_photos.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import st.slex.feature_photos.ui.mapper.MapperPhotoDataUI
import st.slex.feature_photos.ui.mapper.MapperPhotoUrlsDataUI
import st.slex.feature_photos.ui.mapper.MapperProfileUrlDataUI
import st.slex.feature_photos.ui.mapper.MapperUserDataUI

@Module
@InstallIn(SingletonComponent::class)
interface MapperModule {

    @Binds
    fun providesMapperPhotoDataUI(mapper: MapperPhotoDataUI.Base): MapperPhotoDataUI

    @Binds
    fun providesMapperPhotoUrlsDataUI(mapper: MapperPhotoUrlsDataUI.Base): MapperPhotoUrlsDataUI

    @Binds
    fun providesMapperProfileUrlDataUI(mapper: MapperProfileUrlDataUI.Base): MapperProfileUrlDataUI

    @Binds
    fun providesMapperUserDataUI(mapper: MapperUserDataUI.Base): MapperUserDataUI
}