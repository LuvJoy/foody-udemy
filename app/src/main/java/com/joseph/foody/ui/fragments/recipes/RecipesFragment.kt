package com.joseph.foody.ui.fragments.recipes

import android.os.Bundle
import android.view.View
import com.joseph.foody.R
import com.joseph.foody.base.BaseFragment
import com.joseph.foody.databinding.FragmentRecipesBinding


class RecipesFragment : BaseFragment<FragmentRecipesBinding>(R.layout.fragment_recipes) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.showShimmer()
    }

}