package com.joseph.foody.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.navArgs
import com.joseph.foody.R
import com.joseph.foody.adapters.PagerAdapter
import com.joseph.foody.databinding.ActivityDetailBinding
import com.joseph.foody.ui.fragments.IngredientFragment
import com.joseph.foody.ui.fragments.instruction.InstructionFragment
import com.joseph.foody.ui.fragments.overview.OverviewFragment

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val args by navArgs<DetailActivityArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@DetailActivity, R.layout.activity_detail)

        initActionBar()
        initTabLayout()

    }

    private fun initActionBar() {
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun initTabLayout() {
        val fragments = ArrayList<Fragment>()
        fragments.apply {
            add(OverviewFragment())
            add(IngredientFragment())
            add(InstructionFragment())
        }

        val titles = ArrayList<String>()
        titles.apply {
            add("Overview")
            add("Ingredient")
            add("Instructions")
        }

        val resultBundle = Bundle()
        resultBundle.putParcelable("recipeBundle", args.result)

        val adapter = PagerAdapter(
            resultBundle = resultBundle,
            fragments = fragments,
            title = titles,
            fm = supportFragmentManager
        )

        binding.apply {
            viewPager.adapter = adapter
            tabLayout.setupWithViewPager(viewPager)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}