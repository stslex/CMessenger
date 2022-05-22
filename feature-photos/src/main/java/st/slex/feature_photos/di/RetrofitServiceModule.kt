package st.slex.feature_photos.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import st.slex.feature_photos.data.service.PhotosService

@Module
@InstallIn(SingletonComponent::class)
class RetrofitServiceModule {

    @Provides
    fun providesPhotosService(retrofit: Retrofit): PhotosService =
        retrofit.create(PhotosService::class.java)
}