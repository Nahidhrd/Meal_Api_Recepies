package com.example.food_recipes.domain.use_case

import android.util.Log
import com.example.food_recipes.core.Resource
import com.example.food_recipes.data.dto.toMealItem
import com.example.food_recipes.domain.model.MealItem
import com.example.food_recipes.domain.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMealListUseCase @Inject constructor(
 private val  mealRepository: MealRepository
){

    operator fun invoke(mealName : String) : Flow<Resource<List<MealItem?>?>> = flow{
        try {
            emit(Resource.Loading())
            val data = mealRepository.getMealList(mealName)

            if (data.isSuccessful && data.body() != null ){
                val ml = data.body()!!.meals
                val mlItem = ml?.map { it?.toMealItem() }
                emit(Resource.Success(mlItem))
            }

        }catch (e: Exception){

            Log.d("Exception", "invoke: ${e.message}")
            emit(Resource.Error(e.message ?: "Some Error"))
        }

    }

}