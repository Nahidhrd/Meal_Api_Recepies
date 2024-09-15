package com.example.food_recipes.domain.model

import androidx.annotation.Keep
@Keep
data class MealItem(
    val id: String = "",
    val title: String = "",
    val thumbMealImage: String = ""
)
