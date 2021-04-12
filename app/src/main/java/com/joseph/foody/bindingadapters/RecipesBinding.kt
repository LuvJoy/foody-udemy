package com.joseph.foody.bindingadapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.joseph.foody.data.database.entities.RecipesEntity
import com.joseph.foody.models.FoodRecipe
import com.joseph.foody.util.NetworkResult

@BindingAdapter("readApiResponse", "readDatabase", requireAll = true)
fun errorImageViewVisivility(
    imageView: ImageView,
    apiResponse: NetworkResult<FoodRecipe>?,
    database: List<RecipesEntity>?
) {
    if (apiResponse is NetworkResult.Error && database.isNullOrEmpty()) {
        imageView.visibility = View.VISIBLE
    } else if (apiResponse is NetworkResult.Loading) {
        imageView.visibility = View.INVISIBLE
    } else if (apiResponse is NetworkResult.Success) {
        imageView.visibility = View.INVISIBLE
    }
}

@BindingAdapter("readApiResponseTV", "readDatabaseTV", requireAll = true)
fun errorTextViewVisivility(
    textView: TextView,
    apiResponse: NetworkResult<FoodRecipe>?,
    database: List<RecipesEntity>?
) {
    if (apiResponse is NetworkResult.Error && database.isNullOrEmpty()) {
        textView.visibility = View.VISIBLE
        textView.text = apiResponse.message.toString()
    } else if (apiResponse is NetworkResult.Loading) {
        textView.visibility = View.INVISIBLE
    } else if (apiResponse is NetworkResult.Success) {
        textView.visibility = View.INVISIBLE
    }
}
