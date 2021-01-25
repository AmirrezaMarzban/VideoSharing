package com.example.videosharing.extensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.signature.ObjectKey
import com.example.videosharing.R

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) =
    Glide.with(view.context).load(url).signature(ObjectKey(System.currentTimeMillis())).placeholder(
        R.drawable.placeholder
    ).error(R.drawable.placeholder).centerInside().into(view)
