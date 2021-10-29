package com.upday.assignment.data.api

import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiService: ApiService) {

    fun getImages(page: Int) = apiService.getImages(page)
}