package com.upday.assignment.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.upday.assignment.data.model.Data
import com.upday.assignment.data.model.Response
import com.upday.assignment.data.repository.MainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    var dataList: LiveData<PagedList<Data>>
    private val newsDataSourceFactory: NewsDataSourceFactory
    private val responseImages = MutableLiveData<Response>()
    private val exceptionResponse = MutableLiveData<String>()
    private val compositeDisposable = CompositeDisposable()

    init {
        newsDataSourceFactory = NewsDataSourceFactory(compositeDisposable, mainRepository)
        val config = PagedList.Config.Builder()
            .setPageSize(5)
            .setInitialLoadSizeHint(5 * 2)
            .setEnablePlaceholders(false)
            .build()
        dataList = LivePagedListBuilder<Int, Data>(newsDataSourceFactory, config).build()
//        getImages(1)
    }

    fun getImages(page:Int) {
        compositeDisposable.add(
            mainRepository.getImages(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ items ->
                    responseImages.postValue(items)
                }, { throwable ->
                    exceptionResponse.postValue(throwable.localizedMessage)
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getImagesResponse(): LiveData<Response> {
        return responseImages
    }

    fun getExceptionResponse(): LiveData<String> {
        return exceptionResponse
    }
}