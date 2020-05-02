package com.jslps.joharmarketapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jslps.joharmarketapp.R
import com.jslps.joharmarketapp.data.db.AppDatabase
import com.jslps.joharmarketapp.data.network.response.Detail
import com.jslps.joharmarketapp.data.repository.UserRepository
import com.jslps.joharmarketapp.databinding.ActivityLoginBinding
import com.jslps.joharmarketapp.inputs.Input_Dealers
import com.jslps.joharmarketapp.ui.dashboard.DashboardActivity
import com.jslps.joharmarketapp.util.AppConstant
import com.sonu.mvvmsampleapp.data.network.MyApi
import com.sonu.mvvmsampleapp.util.hide
import com.sonu.mvvmsampleapp.util.show
import com.sonu.mvvmsampleapp.util.toast
import kotlinx.android.synthetic.main.activity_login.*
import net.simplifiedcoding.mvvmsampleapp.data.network.NetworkConnectionInterceptor

class LoginActivity : AppCompatActivity(),LoginListner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val networkConnectionInterceptor = NetworkConnectionInterceptor(this)
        val api = MyApi(networkConnectionInterceptor)
        val db = AppDatabase(this)
        val respository = UserRepository(api,db)
        val viewModelFactory = LoginViewModelFactory(respository)

        val binding:ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(LoginViewModel::class.java)
        binding.loginviewmodel = viewModel

        viewModel.authListner=this
        val textView = findViewById(R.id.textView) as TextView
        textView.setOnClickListener {
           /* val intent = Intent(this, Input_Dealers::class.java)
            startActivity(intent)*/
        }

        viewModel.getLoggedUser().observe(this, Observer {user->
            if(user!=null){
                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("loggeduser", user.name)
                AppConstant.roleofuser=user.role
                startActivity(intent)
                finish()
            }
        })
    }

    override fun onStarted() {
        progressbarid.show()
    }

    override fun onSuccess(detail: Detail) {
        progressbarid.hide()
        toast("${detail.Name} logged in Successfully")
    }

    override fun onFailure(message: String) {
        progressbarid.hide()
        toast("Invalid Username or Password");
    }

}
