package com.jslps.joharmarketapp.ui.market.ui.goatry

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import com.jslps.joharmarketapp.R
import com.jslps.joharmarketapp.ui.market.AddMarket

class GoatryFragment : Fragment() {

    private lateinit var viewModel: GoatryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(GoatryViewModel::class.java)
        val root = inflater.inflate(R.layout.goatry_fragment, container, false)
        init()
        return root
    }

    fun init(){
        val listner = activity as AddMarket?
        listner?.marketlistner?.setTitle(getString(R.string.add_goatry_products))
    }

}
