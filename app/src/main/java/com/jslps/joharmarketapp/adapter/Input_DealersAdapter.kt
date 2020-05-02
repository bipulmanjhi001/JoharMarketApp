package com.jslps.joharmarketapp.adapter

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.jslps.joharmarketapp.R
import com.jslps.joharmarketapp.inputs.Detail_View_Input_Provider
import com.jslps.joharmarketapp.model.Input_DealersModel

class Input_DealersAdapter(
    internal var context: Context,
    var resource: Int,
    var input_dealersModels: List<Input_DealersModel>
) : ArrayAdapter<Input_DealersModel?>(context, resource, input_dealersModels) {
    @SuppressLint("NewApi")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View
    {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(resource, null, false)
        val textViewName = view.findViewById<TextView>(R.id.name)
        val contact = view.findViewById<Button>(R.id.contact)
        val details = view.findViewById<Button>(R.id.details)
        val input_dealersModel = input_dealersModels[position]
        textViewName.text = input_dealersModel.name
        contact.setOnClickListener(View.OnClickListener {
            val mobileNo = "790393105"
            val uri = "tel:" + mobileNo.trim { it <= ' ' }
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse(uri)
            if (context.checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return@OnClickListener
            }
            context.startActivity(intent)
        })
        details.setOnClickListener {
            val intent = Intent(context, Detail_View_Input_Provider::class.java)
            context.startActivity(intent)
        }
        return view
    }
}