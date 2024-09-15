package com.example.food_recipes.core.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.food_recipes.R

@BindingAdapter("urlImage")
fun urlToImageview(view : ImageView, imgUrl : String) {

    val option = RequestOptions.placeholderOf(R.drawable.placeholder)
        .error(R.drawable.placeholder)

         Glide.with(view).
         setDefaultRequestOptions(option)
        .load(imgUrl).into(view)
}