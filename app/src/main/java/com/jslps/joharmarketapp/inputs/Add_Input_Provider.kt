package com.jslps.joharmarketapp.inputs

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.jslps.joharmarketapp.R
import com.jslps.joharmarketapp.inputs.Add_Input_Provider
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException

class Add_Input_Provider : AppCompatActivity() {
    var Save: Button? = null
    var photo: ImageView? = null
    var image: String? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EnableRuntimePermission()
        setContentView(R.layout.activity_add_input_provider)
        Save = findViewById<View>(R.id.Save) as Button
        Save!!.setOnClickListener {
            val intent = Intent(this@Add_Input_Provider, Add_Input_Product::class.java)
            startActivity(intent)
        }
        photo = findViewById<View>(R.id.photo) as ImageView
        photo!!.setOnClickListener { selectImage(this@Add_Input_Provider) }
    }

    fun EnableRuntimePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.CAMERA
            )
        ) {
            Toast.makeText(
                this,
                "CAMERA permission allows us to Access CAMERA app",
                Toast.LENGTH_LONG
            ).show()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                RequestPermissionCode
            )
        }
    }

    override fun onRequestPermissionsResult(
        RC: Int,
        per: Array<String>,
        PResult: IntArray
    ) {
        when (RC) {
            RequestPermissionCode -> if (PResult.size > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(
                    this,
                    "Permission Granted, Now your application can access CAMERA.",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Permission Canceled, Now your application cannot access CAMERA.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun selectImage(context: Context?) {
        val options =
            arrayOf<CharSequence>("Take Photo", "Choose from Gallery", "Cancel")
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Choose your product picture")
        builder.setItems(options) { dialog, item ->
            if (options[item] == "Take Photo") {
                val takePicture =
                    Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(takePicture, 0)
            } else if (options[item] == "Choose from Gallery") {
                val pickPhoto = Intent(
                    Intent.ACTION_PICK,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                )
                startActivityForResult(pickPhoto, 1)
            } else if (options[item] == "Cancel") {
                dialog.dismiss()
            }
        }
        builder.show()
    }

    fun getStringImage(bmp: Bitmap): String {
        val baos = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val imageBytes = baos.toByteArray()
        return Base64.encodeToString(imageBytes, Base64.DEFAULT)
    }

    public override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_CANCELED) {
            when (requestCode) {
                0 -> if (resultCode == Activity.RESULT_OK && data != null) {
                    val extras = data.extras
                    val selectedImage = extras["data"] as Bitmap
                    image = getStringImage(selectedImage)
                }
                1 -> if (resultCode == Activity.RESULT_OK && data != null) {
                    try {
                        val imageUri = data.data
                        val imageStream =
                            contentResolver.openInputStream(imageUri)
                        val selectedImage = BitmapFactory.decodeStream(imageStream)
                        image = getStringImage(selectedImage)
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }

    companion object {
        const val RequestPermissionCode = 1
    }
}