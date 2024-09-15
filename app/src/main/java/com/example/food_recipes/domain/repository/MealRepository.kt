package com.example.food_recipes.domain.repository

import com.example.food_recipes.data.dto.ResponseMealDTO
import retrofit2.Response

interface MealRepository {

  suspend  fun getMealList(mealName: String) : Response<ResponseMealDTO>

}