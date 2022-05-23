package st.slex.core_model

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import st.slex.core_model.mapper.MapperPhotoDataUI
import st.slex.core_model.mapper.MapperPhotoUrlsDataUI
import st.slex.core_model.mapper.MapperProfileUrlDataUI
import st.slex.core_model.mapper.MapperUserDataUI

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