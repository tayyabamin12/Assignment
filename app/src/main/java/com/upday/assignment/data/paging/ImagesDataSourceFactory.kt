package com.upday.assignment.data.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.upday.assignment.data.model.Data
import com.upday.assignment.data.repository.MainRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ImagesDataSourceFactory @Inject constructor(
    private val imagesDataSource: ImagesDataSource)
    : DataSource.Factory<Int, Data>() {

    val imagesDataSourceLiveData = MutableLiveData<ImagesDataSource>()

    override fun create(): DataSource<Int, Data> {
        imagesDataSourceLiveData.postValue(imagesDataSource)
        return imagesDataSource
    }
}