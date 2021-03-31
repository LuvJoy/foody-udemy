package com.joseph.foody.ui.fragments.favorites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.joseph.foody.R
import com.joseph.foody.adapters.FavoriteRecipesAdapter
import com.joseph.foody.base.BaseFragment
import com.joseph.foody.databinding.FragmentFavoriteRecipesBinding
import com.joseph.foody.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteRecipesFragment :
    BaseFragment<FragmentFavoriteRecipesBinding>(R.layout.fragment_favorite_recipes) {

    private val mainViewModel: MainViewModel by viewModels()
    private val mAdapter: FavoriteRecipesAdapter by lazy { FavoriteRecipesAdapter(requireActivity(), mainViewModel) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainViewModel = mainViewModel
        binding.mAdapter = mAdapter

        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.favoriteRecipesRecyclerView.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}