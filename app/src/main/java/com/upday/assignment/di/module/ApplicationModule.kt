package com.upday.assignment.di.module

import com.upday.assignment.data.api.ApiHelper
import com.upday.assignment.data.api.ApiService
import com.upday.assignment.data.api.ApiServiceImpl
import com.upday.assignment.data.paging.ImagesDataSource
import com.upday.assignment.data.paging.ImagesDataSourceFactory
import com.upday.assignment.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    @Singleton
    fun provideApiServiceImpl() = ApiServiceImpl()

    @Provides
    @Singleton
    fun provideApiService(apiServiceImpl: ApiServiceImpl) : ApiService = apiServiceImpl

    @Provides
    @Singleton
    fun provideApiHelper(apiService: ApiService) = ApiHelper(apiService)

    @Provides
    @Singleton
    fun provideMainRepository(apiHelper: ApiHelper) = MainRepository(apiHelper)

    @Provides
    @Singleton
    fun provideImagesDataSource(mainRepository: MainRepository, compositeDisposable: CompositeDisposable) = ImagesDataSource(mainRepository, compositeDisposable)

    @Provides
    @Singleton
    fun provideImagesDataSourceFactory(imagesDataSource: ImagesDataSource) = ImagesDataSourceFactory(imagesDataSource)
}