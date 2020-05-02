package com.sonu.mvvmsampleapp.util

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

fun Context.toast(message:String) =
    Toast.makeText(this,message, Toast.LENGTH_LONG).show()

fun ConstraintLayout.show(){
    visibility = View.VISIBLE
}

fun ConstraintLayout.hide(){
    visibility = View.GONE
}