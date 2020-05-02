package com.jslps.joharmarketapp.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cn.pedant.SweetAlert.SweetAlertDialog
import com.jslps.joharmarketapp.R
import com.jslps.joharmarketapp.data.db.AppDatabase
import com.jslps.joharmarketapp.data.model.SeedDataDashboardModel
import com.jslps.joharmarketapp.data.repository.DashboardRepository
import com.jslps.joharmarketapp.data.seeddata.DashboardSeedData
import com.jslps.joharmarketapp.databinding.ActivityDashboardBinding
import com.jslps.joharmarketapp.ui.login.LoginActivity
import com.jslps.joharmarketapp.ui.market.MarketHome
import com.sonu.mvvmsampleapp.util.toast
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.input_dealerlist_layout.*
import net.simplifiedcoding.ui.movies.DashboardAdapter


class DashboardActivity : AppCompatActivity(), Dashboardlistner,DashboardRecyclerListner {
    var viewModel:ViewModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val db = AppDatabase(this)
        val seedData = DashboardSeedData()
        val respository = DashboardRepository(db,seedData)
        val viewModelFactory = DashboardViewModelFactory(respository)

        val binding: ActivityDashboardBinding = DataBindingUtil.setContentView(this,R.layout.activity_dashboard)
        viewModel = ViewModelProvider(this,viewModelFactory).get(DashboardViewModel::class.java)
        binding.dashboardviewmodel = viewModel as DashboardViewModel
        (viewModel as DashboardViewModel).dashboardlistner = this


        //setting recyclerview
        (viewModel as DashboardViewModel).getSeedData()

        (viewModel as DashboardViewModel).data.observe(this, Observer {seedData->
            list_dashboard.also {
                it.layoutManager = LinearLayoutManager(this)
                it.setHasFixedSize(true)
                it.adapter = DashboardAdapter(seedData,this)
            }
        })


        init();
    }

    private fun init() {

        val intent = getIntent()
        val loggeduser = intent.getStringExtra("loggeduser")
        textView3.text = "Welcome "+ loggeduser

    }

    override fun logout() {
        val alert = SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
        alert.setTitleText("Log Out")
        alert.contentText = "Are you sure to log out?"
        alert.confirmText = "OK"
        alert.setCustomImage(R.drawable.logout_icon)
        alert.setConfirmClickListener { sDialog ->
            (viewModel as DashboardViewModel).deleteUser()
            sDialog.dismissWithAnimation()

        }
        alert.setCancelable(true)
        alert.show()
    }

    override fun loggedout() {
        toast("Logged Out Successfully")
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun itemClickListnerDashboard(view: View, data: SeedDataDashboardModel) {
        when(view.id){
            R.id.const_left -> {
                when (data.title_left) {
                    "Market" -> startActivity(Intent(this,MarketHome::class.java))
                    "Machine" -> toast("machine")
                    "Veterinary" -> toast("Veterinary")
                    "Logistics" -> toast("Logistics")
                }
            }
            R.id.const_right ->{
                when (data.title_right) {
                    "Buyers" -> toast("Buyers")
                    "Inputs" -> startActivity(Intent(this,Input_Dealers::class.java))
                    "Warehouse" -> toast("Warehouse")
                    "Mandi Prices" -> toast("Mandi Prices")
                }
            }
        }
    }
}
