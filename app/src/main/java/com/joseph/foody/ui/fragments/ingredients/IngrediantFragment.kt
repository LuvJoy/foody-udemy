package com.joseph.foody.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.joseph.foody.R
import com.joseph.foody.adapters.IngredientsAdapter
import com.joseph.foody.base.BaseFragment
import com.joseph.foody.databinding.FragmentIngredientBinding
import com.joseph.foody.models.Result
import com.joseph.foody.util.Constants.Companion.RECIPE_RESULT

class IngredientFragment : BaseFragment<FragmentIngredientBinding>(R.layout.fragment_ingredient) {

    private val mAdapter: IngredientsAdapter by lazy { IngredientsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        initView()
    }

    private fun initView() {
        val args = arguments
        val myBundle: Result? = args?.getParcelable(RECIPE_RESULT)

        myBundle?.extendedIngredients?.let { mAdapter.setData(it) }
    }

    private fun setupRecyclerView() {
        binding.ingredientRecyclerview.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}
