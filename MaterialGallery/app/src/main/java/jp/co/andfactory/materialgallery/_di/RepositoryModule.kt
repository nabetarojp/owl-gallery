package jp.co.andfactory.materialgallery._di

import dagger.Module
import dagger.Provides
import jp.co.andfactory.materialgallery.infra.api.FlickrApiService
import jp.co.andfactory.materialgallery.infra.database.OrmaDatabaseWrapper
import jp.co.andfactory.materialgallery.infra.repository.*
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by watanabe on 2017/12/24.
 */

@Module
class RepositoryModule() {

    @Named("flickr_remote")
    @Singleton
    @Provides
    fun provideImageFlickrRemoteDataSource(flickrApiService: FlickrApiService): ImageFlickrDataSource
            = ImageFlickrRemoteDataSource(flickrApiService)

    @Named("flickr_local")
    @Singleton
    @Provides
    fun provideImageFlickrLocalDataSource(orma: OrmaDatabaseWrapper): ImageFlickrDataSource
            = ImageFlickrLocalDataSource(orma)


    @Singleton
    @Provides
    fun provideImageFlickrRepository(
            @Named("flickr_remote") remoteDataSource: ImageFlickrDataSource,
            @Named("flickr_local") localDataSource: ImageFlickrDataSource
    ): ImageFlickrRepository {
        return ImageFlickrRepositoryImpl(remoteDataSource, localDataSource)
    }
}