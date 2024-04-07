package com.example.dogs_api.model

import com.google.gson.annotations.SerializedName


data class DogAPIResponse(
    val id: String,
    val name: String,
    @SerializedName("image_link") val imageUrl: String,
    @SerializedName("good_with_children") val goodWithChildren: Int,
    val playfulness: Int,
    val protectiveness: Int,
    val energy: Int,
    @SerializedName("min_life_expectancy") val minLifeExpectancy: Int
)
