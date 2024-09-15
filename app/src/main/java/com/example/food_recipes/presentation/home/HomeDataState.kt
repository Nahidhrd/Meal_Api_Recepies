package com.example.food_recipes.presentation.home

import com.example.food_recipes.domain.model.MealItem

data class HomeDataState(
    val loading: Boolean = false,
    val homeData: List<MealItem?>? = null,
    val error: String? = null
)