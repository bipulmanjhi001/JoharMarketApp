package com.jslps.joharmarketapp.ui.login

import android.view.View
import androidx.lifecycle.ViewModel
import com.jslps.joharmarketapp.data.db.User
import com.jslps.joharmarketapp.data.repository.UserRepository
import com.sonu.mvvmsampleapp.util.ApiException
import com.sonu.mvvmsampleapp.util.Coroutines
import com.sonu.mvvmsampleapp.util.NoInternetException
import java.util.*

class LoginViewModel(
    private val repository: UserRepository
) : ViewModel() {

    var username: String? = null
    var password: String? = null

    var authListner:LoginListner?=null

    fun getLoggedUser() = repository.getUser()


    fun onLoginButtonClick(view: View){
        authListner?.onStarted()
        if(username.isNullOrEmpty() || password.isNullOrEmpty()){
            authListner?.onFailure("Username or password is empty")
        }else{

            Coroutines.main{
                try {
                    val authResponse = repository.userLogin(username!!,password!!)
                    authResponse.Detail?.let {
                        authListner?.onSuccess(it)
                        val user = User(username!!.toLowerCase(Locale.ROOT),password!!.toLowerCase(Locale.ROOT),it.UserId,it.Role,it.Address);
                        val value = repository.saveUser(user)
                        return@main
                    }

                    authListner?.onFailure(authResponse.Status)

                }catch (e: ApiException){
                    authListner?.onFailure(e.message!!)
                }catch (e: NoInternetException){
                    authListner?.onFailure(e.message!!)
                }

            }
        }


    }
}