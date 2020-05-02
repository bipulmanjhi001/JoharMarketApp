package com.jslps.joharmarketapp.ui.market.ui.ntfp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.jslps.joharmarketapp.R
import com.jslps.joharmarketapp.ui.market.AddMarket

class NtfpFragment : Fragment() {

    private lateinit var viewModel: NtfpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(NtfpViewModel::class.java)
        val root = inflater.inflate(R.layout.ntfp_fragment, container, false)
        init()
        return root
    }

    fun init(){
        //  ViewModel viewModel = ViewModelProviders.of(this,viewModelFactory).get(DashboardViewModel.class)
        val listner = activity as AddMarket?
        listner?.marketlistner?.setTitle(getString(R.string.add_ntfp_products))
    }

}
