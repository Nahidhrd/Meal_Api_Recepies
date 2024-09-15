package com.example.food_recipes.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.food_recipes.databinding.ItemMealGirdBinding
import com.example.food_recipes.domain.model.MealItem

class HomeAdapter(): ListAdapter<MealItem,HomeAdapter.HomeViewHolder>(
    COMPARATOR) {

    inner class HomeViewHolder(val binding: ItemMealGirdBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(ItemMealGirdBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.binding.meal = getItem(position)
    }

    companion object {

        val COMPARATOR = object :DiffUtil.ItemCallback<MealItem>(){
            override fun areItemsTheSame(oldItem: MealItem, newItem: MealItem): Boolean {
               return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: MealItem, newItem: MealItem): Boolean {
                return oldItem.id == newItem.id
            }


        }

    }

}