package com.upday.assignment.data.api

import com.upday.assignment.data.model.Response
import io.reactivex.Single

interface ApiService {

    fun getImages(page: Int): Single<Response>
}