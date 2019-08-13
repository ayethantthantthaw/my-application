package com.example.walmal
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.bumptech.glide.Glide
import com.example.walmal.Objects.Product
import kotlinx.android.synthetic.main.activity_product__detail.*


class Product_Detail : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product__detail)

        tv_product_title.setText(Product.title)
        tv_product_price.setText("$"+ Product.price)
        tv_product_qty.setText(Product.qty+" item(s) in stock")
        tv_content.setText(Product.product_content)
        Glide.with(this).load(Product.img).into(imgProduct)
        btn_addCart.setOnClickListener {
            val i=Intent(this@Product_Detail,ActivityCart::class.java)
            startActivity(i)
        }


}}


