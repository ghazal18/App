package com.example.myapplication.util

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.myapplication.R

object BindingUtil {

    @JvmStatic
    @BindingAdapter("setDate") // just an example
    fun setDate(view: TextView, value: String) {
        view.text = value + "hello"
        view.setTextColor(ContextCompat.getColor(view.context, R.color.teal_700))
    }


    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(view: ImageView, url: String?) {
        Glide.with(view)
            .load(url)
            .into(view)
        }
}