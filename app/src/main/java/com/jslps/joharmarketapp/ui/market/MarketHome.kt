package com.jslps.joharmarketapp.ui.market

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jslps.joharmarketapp.R
import kotlinx.android.synthetic.main.activity_market__home.*

class MarketHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market__home)
        init()
    }

    fun init(){
        overridePendingTransition(R.anim.fadein, R.anim.fadeout)
        floatingActionButton.setOnClickListener{
            startActivity(Intent(this,AddMarket::class.java))
        }
    }
}
