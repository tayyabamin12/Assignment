package com.upday.assignment.data.api

import com.rx2androidnetworking.Rx2AndroidNetworking
import com.upday.assignment.BuildConfig
import com.upday.assignment.data.model.Response
import io.reactivex.Single


class ApiServiceImpl : ApiService {

    private var baseUrl = "https://api.shutterstock.com/v2/images/search"

    override fun getImages(page: Int): Single<Response> {
        return Rx2AndroidNetworking.get(baseUrl)
            .addHeaders("Accept", "application/json")
            .addHeaders("Authorization", "Bearer ".plus(BuildConfig.apiKey))
            .addQueryParameter("page", page.toString())
            .build()
            .getObjectSingle(Response::class.java)
    }
}