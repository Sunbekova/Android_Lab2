package com.example.dogs_api.model
import java.util.UUID

data class Dog(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val imageUrl: String,
    val goodWithChildren: Int,
    val playfulness: Int,
    val protectiveness: Int,
    val energy: Int,
    val minLifeExpectancy: Int
) {
    companion object {

        fun toDog(dogApi: DogAPI) = Dog(
            id = dogApi.id,
            name = dogApi.name,
            imageUrl = dogApi.imageUrl,
            goodWithChildren = dogApi.goodWithChildren,
            playfulness = dogApi.playfulness,
            protectiveness = dogApi.protectiveness,
            energy = dogApi.energy,
            minLifeExpectancy = dogApi.minLifeExpectancy
        )
    }
}

