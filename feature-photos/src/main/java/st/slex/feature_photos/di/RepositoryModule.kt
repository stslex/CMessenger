package st.slex.feature_photos.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import st.slex.feature_photos.data.repository.PhotosRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun providePhotosRepository(repository: PhotosRepository.Base): PhotosRepository
}