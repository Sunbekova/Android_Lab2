package com.example.dogs_api.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogs_api.model.Dog
import com.bumptech.glide.Glide
import com.example.dogs_api.databinding.ItemDogBinding
import com.example.dogs_api.model.DogAPIResponse

class DogAdapter : RecyclerView.Adapter<DogAdapter.ViewHolder>() {
    private var dogList: List<DogAPIResponse> = ArrayList()

    fun setData(dogs: List<DogAPIResponse>) {
        dogList = dogs
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dogList[position])
    }

    override fun getItemCount() = dogList.size

    inner class ViewHolder(private val binding: ItemDogBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dog: DogAPIResponse) {
            with(binding) {
                Glide.with(itemView)
                    .load(dog.imageUrl)
                    .into(image)

                name.text = dog.name
                goodWithChildren.text = "Good With Children: ${dog.goodWithChildren}"
                playfulness.text = "Playfulness: ${dog.playfulness}"
                protectiveness.text = "Protectiveness: ${dog.protectiveness}"
                energy.text = "Energy: ${dog.energy}"
                minLifeExpantancy.text = "Min Life Expectancy: ${dog.minLifeExpectancy}"
            }
        }
    }
}
