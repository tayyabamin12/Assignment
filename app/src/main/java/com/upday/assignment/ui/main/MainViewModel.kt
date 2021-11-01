package com.upday.assignment.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.upday.assignment.data.model.Data
import com.upday.assignment.data.paging.ImagesDataSourceFactory
import com.upday.assignment.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val imagesDataSourceFactory: ImagesDataSourceFactory,
    private val compositeDisposable: CompositeDisposable
) : ViewModel() {

    var dataList: LiveData<PagedList<Data>>
    private val pageSize = 10

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(false)
            .build()
        dataList = LivePagedListBuilder(imagesDataSourceFactory, config).build()
    }

    fun getState(): MutableLiveData<State>? {
        return imagesDataSourceFactory.imagesDataSourceLiveData.value?.state
    }

    fun retry() {
        imagesDataSourceFactory.imagesDataSourceLiveData.value?.retry()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}