package com.example.dogs_api

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogs_api.adapter.DogAdapter
import com.example.dogs_api.databinding.ActivityMainBinding
import com.example.dogs_api.model.DogAPIResponse
import com.example.dogs_api.network.DogApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var dogAdapter: DogAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dogAdapter = DogAdapter()
        binding.recyclerView.adapter = dogAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Set up search functionality
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    if (it.isEmpty()) {
                        dogAdapter.setData(emptyList())
                    } else {
                        findDogsByName(it)
                    }
                }
                return true
            }

        })
    }

    private fun findDogsByName(name: String) {
        val client = DogApiClient.api
        val response = client.fetchDogDetails(name)
        response.enqueue(object : Callback<List<DogAPIResponse>> {
            override fun onResponse(
                call: Call<List<DogAPIResponse>>,
                response: Response<List<DogAPIResponse>>
            ) {
                if (response.isSuccessful) {
                    val dogResponse = response.body()
                    dogResponse?.let {
                        dogAdapter.setData(it)
                    }
                } else {
                    // Handle unsuccessful response
                    Log.e("MainActivity", "Failed to fetch data: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<DogAPIResponse>>, t: Throwable) {
                // Handle network failure
                Log.e("MainActivity", "Network call failed", t)
            }
        })
    }

}
