package com.example.food_recipes.data.remote

import com.example.food_recipes.data.dto.ResponseMealDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface MealApiService {

    @GET("json/v1/1/filter.php?")
    suspend fun getMealList(
        @Query("c") mealName: String
    ) : Response<ResponseMealDTO>

}