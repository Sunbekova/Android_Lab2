package com.example.dogs_api.network

import com.example.dogs_api.model.DogAPIResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface DogService {
    @Headers("X-Api-Key:iGpsWSr5PUdHxcwUmmUyBQ==TNhX3IzI1E1ITiE3")
    @GET("dogs")
    fun fetchDogDetails(@Query("name") name: String): Call<List<DogAPIResponse>>
}

