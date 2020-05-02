package com.jslps.joharmarketapp.ui.market.ui.poultry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jslps.joharmarketapp.R
import com.jslps.joharmarketapp.ui.market.AddMarket


class PoultryFragment : Fragment() {

    private lateinit var poultryViewModel: PoultryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        poultryViewModel =
            ViewModelProvider(this).get(PoultryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_poultry, container, false)
        init()
        return root
    }

    fun init(){
        // ViewModel viewModel = ViewModelProviders.of(this,viewModelFactory).get(DashboardViewModel.class)
        val listner = activity as AddMarket?
        listner?.marketlistner?.setTitle(getString(R.string.add_poultry_products))
    }
}