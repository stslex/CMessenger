package st.slex.feature_photos.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import st.slex.feature_photos.data.repository.PhotosRepository
import st.slex.feature_photos.data.repository.PhotosRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsPhotosRepository(repository: PhotosRepositoryImpl): PhotosRepository
}