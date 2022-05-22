package st.slex.feature_photos.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    fun providesRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun providesRetrofitClient(
        mLoggingInterceptor: HttpLoggingInterceptor,
        interceptor: Interceptor,
        application: Application
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(mLoggingInterceptor)
        .addInterceptor(interceptor)
        .cache(Cache(application.cacheDir, CACHE_SIZE))
        .build()

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun providesOnlineInterceptor(): Interceptor = Interceptor { chain ->
        val response = chain.proceed(chain.request())
        response.newBuilder()
            .header(HEADER_NAME, HEADER_ONLINE_VALUE)
            .removeHeader(HEADER_PRAGMA)
            .build()
    }

    companion object {
        private const val BASE_URL = "https://api.unsplash.com/"
        private const val MAX_AGE: Int = 60 * 60 * 3
        private const val HEADER_NAME = "Cache-Control"
        private const val HEADER_ONLINE_VALUE = "public, max-age=$MAX_AGE"
        private const val HEADER_PRAGMA = "Pragma"
        private const val CACHE_SIZE: Long = 10 * 1024 * 1024 * 8L
    }
}