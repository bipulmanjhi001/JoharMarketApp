package net.simplifiedcoding.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("image")
fun loadImage(view: ImageView, image: Int) {
    Glide.with(view)
        .load(image)
        .into(view)
}