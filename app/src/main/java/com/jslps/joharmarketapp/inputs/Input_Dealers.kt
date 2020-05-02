package com.jslps.joharmarketapp.inputs

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.jslps.joharmarketapp.R
import com.jslps.joharmarketapp.adapter.Input_DealersAdapter
import com.jslps.joharmarketapp.model.Input_DealersModel
import java.util.*

class Input_Dealers : AppCompatActivity() {
    var next: Button? = null
    var Input_Dealers: ListView? = null
    var input_dealersModelList: MutableList<Input_DealersModel>? = null
    var fab: FloatingActionButton? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_input_dealers)
        Input_Dealers =
            findViewById<View>(R.id.Input_Dealers) as ListView
        input_dealersModelList = ArrayList()
        (input_dealersModelList as ArrayList<Input_DealersModel>).add(Input_DealersModel("Jai Trading Co."))
        (input_dealersModelList as ArrayList<Input_DealersModel>).add(Input_DealersModel("Prithvi Seed Retailer"))
        (input_dealersModelList as ArrayList<Input_DealersModel>).add(Input_DealersModel("Prakash Wholesaler"))
        val adapter = Input_DealersAdapter(
            this@Input_Dealers,
            R.layout.input_dealers_list,
            input_dealersModelList as ArrayList<Input_DealersModel>
        )
        Input_Dealers!!.adapter = adapter
        fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab!!.setOnClickListener {
            val intent = Intent(this@Input_Dealers, Add_Input_Provider::class.java)
            startActivity(intent)
        }
    }
}