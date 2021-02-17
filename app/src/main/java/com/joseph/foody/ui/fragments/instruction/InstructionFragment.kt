package com.joseph.foody.ui.fragments.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.joseph.foody.R
import com.joseph.foody.base.BaseFragment
import com.joseph.foody.databinding.FragmentInstructionBinding
import com.joseph.foody.models.Result
import com.joseph.foody.util.Constants


class InstructionFragment :
    BaseFragment<FragmentInstructionBinding>(R.layout.fragment_instruction) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initWebView()
    }

    private fun initWebView() {
        val args = arguments
        val myBundle: Result? = args?.getParcelable(Constants.RECIPE_RESULT)
        val websiteUrl: String = myBundle!!.sourceUrl

        binding.instructionWebview.apply {
            webViewClient = object : WebViewClient() {}
            loadUrl(websiteUrl)
        }


    }
}


