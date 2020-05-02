package com.jslps.joharmarketapp.ui.market.ui.addmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jslps.joharmarketapp.R
import com.jslps.joharmarketapp.data.db.AppDatabase
import com.jslps.joharmarketapp.data.repository.AddMarketFragmentRepository
import com.jslps.joharmarketapp.databinding.FragmentAddMarketBinding
import com.jslps.joharmarketapp.ui.market.AddMarket
import com.sonu.mvvmsampleapp.data.network.MyApi
import com.sonu.mvvmsampleapp.data.network.MyApi2
import com.sonu.mvvmsampleapp.util.hide
import com.sonu.mvvmsampleapp.util.show
import com.sonu.mvvmsampleapp.util.toast
import kotlinx.android.synthetic.main.fragment_add_market.*
import net.simplifiedcoding.mvvmsampleapp.data.network.NetworkConnectionInterceptor

class AddMarketFragment : Fragment(),AddMarketListner {

    private lateinit var addMarketViewModel: AddMarketViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val db = AppDatabase(activity as AddMarket)
        val networkConnectionInterceptor = NetworkConnectionInterceptor(activity as AddMarket)
        val api = MyApi2(networkConnectionInterceptor)
        val repository = AddMarketFragmentRepository(api,db)
        val viewModelFactory = AddMarketViewModelFactory(repository)

        val binding:FragmentAddMarketBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_market,container,false)
        addMarketViewModel =
            ViewModelProvider(this,viewModelFactory).get(AddMarketViewModel::class.java)

        binding.addmarketviewmodel =addMarketViewModel
        addMarketViewModel.listner=this
        init()
        return binding.root

    }


    fun init(){
        val listner = activity as AddMarket?
        listner?.marketlistner?.setTitle(getString(R.string.add_market))

       // addMarketViewModel.getDistrict();


    }

    override fun onStarted(message: String) {
       // progressbarid1.show()
        //loadingtext.text = message
    }

    override fun onSuccess() {
        progressbarid1.hide()
    }

    override fun onFailure(message: String) {
        progressbarid1.hide()
        (activity as AddMarket).toast(message);
    }
}