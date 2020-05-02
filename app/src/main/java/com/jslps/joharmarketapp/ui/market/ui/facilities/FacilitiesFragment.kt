package com.jslps.joharmarketapp.ui.market.ui.facilities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jslps.joharmarketapp.R
import com.jslps.joharmarketapp.ui.market.AddMarket


class FacilitiesFragment : Fragment() {

    private lateinit var facilitiesViewModel: FacilitiesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        facilitiesViewModel =
            ViewModelProvider(this).get(FacilitiesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_facilities, container, false)

        init()
        return root
    }

    fun init(){
        //  ViewModel viewModel = ViewModelProviders.of(this,viewModelFactory).get(DashboardViewModel.class)
        val listner = activity as AddMarket?
        listner?.marketlistner?.setTitle("Add Wholesale Market Facilities")
    }
}