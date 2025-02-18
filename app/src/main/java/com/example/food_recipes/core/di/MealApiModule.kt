package com.example.food_recipes.core.di

import com.example.food_recipes.data.remote.MealApiService
import com.example.food_recipes.data.repository_impl.MealRepositoryImpl
import com.example.food_recipes.domain.repository.MealRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MealApiModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
       return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMealApiService(
        retrofit: Retrofit
    ): MealApiService {
        return retrofit.create(MealApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMealRepository(mealApiService: MealApiService)
       : MealRepository{
        return MealRepositoryImpl(mealApiService)

    }

}