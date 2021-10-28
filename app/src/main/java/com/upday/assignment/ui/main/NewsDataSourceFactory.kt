package com.upday.assignment.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.upday.assignment.data.model.Data
import com.upday.assignment.data.repository.MainRepository
import io.reactivex.disposables.CompositeDisposable

class NewsDataSourceFactory(
    private val compositeDisposable: CompositeDisposable,
    private val mainRepository: MainRepository)
    : DataSource.Factory<Int, Data>() {

    val newsDataSourceLiveData = MutableLiveData<NewsDataSource>()

    override fun create(): DataSource<Int, Data> {
        val newsDataSource = NewsDataSource(mainRepository, compositeDisposable)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}