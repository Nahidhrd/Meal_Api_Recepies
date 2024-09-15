package com.example.food_recipes

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.lifecycleScope
import com.example.food_recipes.databinding.ActivityMainBinding
import com.example.food_recipes.presentation.home.HomeAdapter
import com.example.food_recipes.presentation.home.HomeDataState
import com.example.food_recipes.presentation.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
     private val viewModel: HomeViewModel by viewModels()
  //  private late init var mealAdapter: HomeAdapter

    private val mealAdapter : HomeAdapter by lazy {
        HomeAdapter()
  }

     private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

   //     mealAdapter = HomeAdapter(applicationContext)
   //     binding.myMealListRecyclerview.adapter = mealAdapter

        binding.myMealListRecyclerview.apply {
            adapter = mealAdapter
        }

        lifecycleScope.launch {
            viewModel.homeMeal.collect{ homeDataState ->
                if (homeDataState.loading){

                }
                if (homeDataState.error != null){


                }
                if ((homeDataState.homeData?.size ?: 0) != 0) {
                   mealAdapter.submitList(homeDataState.homeData)
                }
            }

        }

        viewModel.getMealData("Dessert")
    }
}