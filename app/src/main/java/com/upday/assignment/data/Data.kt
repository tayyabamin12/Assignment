package com.upday.assignment.data

data class Data(
    val aspect: Double,
    val assets: Assets,
    val contributor: Contributor,
    val description: String,
    val has_model_release: Boolean,
    val id: String,
    val image_type: String,
    val media_type: String
)