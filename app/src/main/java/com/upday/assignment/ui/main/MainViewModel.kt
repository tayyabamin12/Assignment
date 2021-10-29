package com.upday.assignment.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.upday.assignment.data.model.Data
import com.upday.assignment.data.paging.ImagesDataSourceFactory
import com.upday.assignment.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(imagesDataSourceFactory: ImagesDataSourceFactory, private val compositeDisposable: CompositeDisposable)
    : ViewModel() {

    var dataList: LiveData<PagedList<Data>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(5)
            .setInitialLoadSizeHint(5 * 2)
            .setEnablePlaceholders(false)
            .build()
        dataList = LivePagedListBuilder(imagesDataSourceFactory, config).build()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}