package com.jslps.joharmarketapp.ui.market.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jslps.joharmarketapp.R
import com.jslps.joharmarketapp.ui.market.AddMarket

class AddMarketProfileFragment : Fragment() {

    private lateinit var addMarketProfileViewModel: AddMarketProfileViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addMarketProfileViewModel =
            ViewModelProvider(this).get(AddMarketProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        init()
        return root
    }

    fun init(){
        val listner = activity as AddMarket?
        listner?.marketlistner?.setTitle(getString(R.string.add_wholesale_market_profile))
    }
}