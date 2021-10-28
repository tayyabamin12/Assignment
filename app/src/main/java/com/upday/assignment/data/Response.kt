package com.upday.assignment.data

data class Response(
    val `data`: List<Data>,
    val page: Int,
    val per_page: Int,
    val search_id: String,
    val total_count: Int
)