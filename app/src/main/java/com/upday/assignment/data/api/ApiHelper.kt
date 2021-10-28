package com.upday.assignment.data.api

class ApiHelper(private val apiService: ApiService) {

    fun getImages(page: Int) = apiService.getImages(page)
}