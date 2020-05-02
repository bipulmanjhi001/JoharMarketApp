package com.jslps.joharmarketapp.ui.market.ui.addmarket

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.jslps.joharmarketapp.R
import com.jslps.joharmarketapp.data.repository.AddMarketFragmentRepository
import com.jslps.joharmarketapp.util.AppConstant
import com.sonu.mvvmsampleapp.util.ApiException
import com.sonu.mvvmsampleapp.util.Coroutines
import com.sonu.mvvmsampleapp.util.NoInternetException
import java.util.*

class AddMarketViewModel(
    private val repository: AddMarketFragmentRepository
) : ViewModel() {

    var listner:AddMarketListner?=null

    fun onClickListnerNext(view:View){
        System.out.println("");
        view.findNavController().navigate(R.id.action_add_to_profile)
    }

    fun getDistrict(){
        listner?.onStarted("please wait,downloading district")
        Coroutines.main{
            try {
                val disrtrictResponse = repository.getDistrict(AppConstant.districtflag);
                if(disrtrictResponse.Master.size>0){
                    listner?.onSuccess()
                }else{
                    listner?.onFailure("No data found for district")
                }
                System.out.println("");

            }catch (e: ApiException){
                listner?.onFailure(e.message!!)
            }catch (e: NoInternetException){
                listner?.onFailure(e.message!!)
            }

        }
    }
}