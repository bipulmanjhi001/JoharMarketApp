package com.jslps.joharmarketapp.mapped_markets

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.jslps.joharmarketapp.R

class Add_Poultry_Products : Fragment() {
    var next: Button? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root =
            inflater.inflate(R.layout.fragment_add__poultry__products, container, false)
        next = root.findViewById<View>(R.id.next) as Button
        next!!.setOnClickListener {
            val intent = Intent(activity, Add_Ntfp_Products::class.java)
            startActivity(intent)
        }
        return root
    }
}