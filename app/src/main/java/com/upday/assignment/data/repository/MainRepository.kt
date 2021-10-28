package com.upday.assignment.data.repository

import com.upday.assignment.data.api.ApiHelper
import com.upday.assignment.data.model.Response
import io.reactivex.Single


class MainRepository(private val apiHelper: ApiHelper) {

    fun getImages(page: Int): Single<Response> {
        return apiHelper.getImages(page)
    }
}
