package com.example.food_recipes.data.repository_impl

import android.annotation.SuppressLint
import com.example.food_recipes.data.dto.ResponseMealDTO
import com.example.food_recipes.data.remote.MealApiService
import com.example.food_recipes.domain.repository.MealRepository
import retrofit2.Response
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
   private val mealApiService: MealApiService
    )
    : MealRepository {
    @SuppressLint("SuspiciousIndentation")
    override suspend fun getMealList(mealName: String): Response<ResponseMealDTO> {
    val response = mealApiService.getMealList(mealName)
        return response
    }
}