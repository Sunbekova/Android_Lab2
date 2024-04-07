package com.example.dogs_api.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object DogApiClient {
    val api: DogService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.api-ninjas.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogService::class.java)
    }

}