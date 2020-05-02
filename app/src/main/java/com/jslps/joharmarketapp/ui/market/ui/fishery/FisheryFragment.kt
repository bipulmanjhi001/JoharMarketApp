package com.jslps.joharmarketapp.ui.market.ui.fishery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.jslps.joharmarketapp.R
import com.jslps.joharmarketapp.ui.market.AddMarket

class FisheryFragment : Fragment() {

    private lateinit var viewModel: FisheryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        viewModel = ViewModelProvider(this).get(FisheryViewModel::class.java)
        val root = inflater.inflate(R.layout.fishery_fragment, container, false)
        init()
        return root
    }

    fun init(){
        //  ViewModel viewModel = ViewModelProviders.of(this,viewModelFactory).get(DashboardViewModel.class)
        val listner = activity as AddMarket?
        listner?.marketlistner?.setTitle(getString(R.string.add_fishery_products))
    }

}
