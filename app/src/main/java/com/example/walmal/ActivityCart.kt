package com.example.walmal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.walmal.Objects.Product
import kotlinx.android.synthetic.main.activity_cart.*

class ActivityCart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        Glide.with(this).load(Product.img).into(imgCart)
    }
}
