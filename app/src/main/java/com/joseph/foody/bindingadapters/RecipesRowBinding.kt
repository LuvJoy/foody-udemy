package com.joseph.foody.bindingadapters

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import coil.load
import com.joseph.foody.R
import com.joseph.foody.models.Result
import com.joseph.foody.ui.fragments.recipes.RecipesFragmentDirections

@BindingAdapter("onRecipeClickListener")
fun onRecipeClickListener(recipeRowLayout: ConstraintLayout, result: Result) {
    recipeRowLayout.setOnClickListener {
        Log.d("TAG", "[TAG] - onRecipeClickListener() : ${result.toString()}")
        try {
            val action = RecipesFragmentDirections.actionRecipesFragmentToDetailActivity(result)
            recipeRowLayout.findNavController().navigate(action)
        } catch (e: Exception) {
            Log.d("TAG", "[TAG] - onRecipeClickListener() : ${e.toString()}")
        }
    }
}


@BindingAdapter("loadImageFromUrl")
fun loadImageFromUrl(imageView: ImageView, imageUrl: String) {
    imageView.load(imageUrl) {
        crossfade(600)
        error(R.drawable.ic_error_placeholder)
    }
}

@BindingAdapter("setNumberOfLikes")
fun setNumberOfLikes(textView: TextView, likes: Int) {
    textView.text = likes.toString()
}

@BindingAdapter("setNumberOfMinutes")
fun setNumberOfMinutes(textView: TextView, minutes: Int) {
    textView.text = minutes.toString()
}

@BindingAdapter("applyVeganColor")
fun applyVeganColor(view: View, vegan: Boolean) {
    if(vegan) {
        when(view) {
            is TextView -> {
                view.setTextColor(ContextCompat.getColor(view.context, R.color.green))
            }
            is ImageView -> {
                view.setColorFilter(ContextCompat.getColor(view.context, R.color.green))
            }
        }
    }
}