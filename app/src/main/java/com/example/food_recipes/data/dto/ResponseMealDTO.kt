package com.example.food_recipes.data.dto


import androidx.annotation.Keep
import com.example.food_recipes.domain.model.MealItem
import com.google.gson.annotations.SerializedName

@Keep
data class ResponseMealDTO(
    @SerializedName("meals")
    val meals: List<Meal?>? = null
) {
    @Keep
    data class Meal(
        @SerializedName("idMeal")
        val idMeal: String? = null,
        @SerializedName("strMeal")
        val strMeal: String? = null,
        @SerializedName("strMealThumb")
        val strMealThumb: String? = null
    )
}

fun ResponseMealDTO.Meal.toMealItem(): MealItem{

    return MealItem(
        id = this.idMeal.toString(),
        title = this.strMeal.toString(),
        thumbMealImage = this.strMealThumb?: "https://png.pngtree.com/png-vector/20220727/ourmid/pngtree-cooking-logo-png-image_6089722.png"
    )
}
