package com.joseph.foody.data.network

import com.joseph.foody.models.FoodRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface FoodRecipeApi {

    @GET("/recipes/complexSearch")
    fun getRecipes(
        @QueryMap queries: Map<String, String>
    ): Response<FoodRecipe>
}