package com.joseph.foody.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.joseph.foody.R
import com.joseph.foody.databinding.IngredientRowLayoutBinding
import com.joseph.foody.models.ExtendedIngredient
import com.joseph.foody.util.Constants.Companion.BASE_IMAGE_URL
import com.joseph.foody.util.RecipesDiffUtil

class IngredientsAdapter : RecyclerView.Adapter<IngredientsAdapter.MyViewHolder>() {

    private var ingredientsList = emptyList<ExtendedIngredient>()

    class MyViewHolder(val binding: IngredientRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view =
            IngredientRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            ingredientImageView.load(BASE_IMAGE_URL + ingredientsList[position].image) {
                crossfade(600)
                error(R.drawable.ic_error_placeholder)
            }
            ingredientName.text = ingredientsList[position].name.capitalize()
            ingredientAmount.text = ingredientsList[position].amount.toString()
            ingredientUnit.text = ingredientsList[position].unit
            ingredientConsistency.text = ingredientsList[position].consistency
            ingredientOriginal.text = ingredientsList[position].original
        }

    }

    override fun getItemCount(): Int {
        return ingredientsList.size
    }

    fun setData(newIngredients: List<ExtendedIngredient>) {
        val ingredientDiffUtil = RecipesDiffUtil(ingredientsList, newIngredients)
        val diffUtilResult = DiffUtil.calculateDiff(ingredientDiffUtil)
        ingredientsList = newIngredients
        diffUtilResult.dispatchUpdatesTo(this)
    }

}