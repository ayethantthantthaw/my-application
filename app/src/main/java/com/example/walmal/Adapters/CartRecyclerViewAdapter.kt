package com.example.walmal.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.walmal.R
import com.example.walmal.post.PostCart
import kotlinx.android.synthetic.main.list_item_cart.view.*

class CartRecyclerViewAdapter(private var list3: List<PostCart>, private var context: Context?):
    RecyclerView.Adapter<CartRecyclerViewAdapter.Myholder3>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Myholder3 {
        val view= LayoutInflater.from(context).inflate(R.layout.list_item_cart,p0,false)
        return Myholder3(view)

    }

    override fun getItemCount(): Int{
        return list3.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(p0: Myholder3, p1: Int) {
        val postCart=list3[p1]
        p0.itemView.tvCart.text="$ ${postCart.seller_name}"
        Glide.with(context).load(postCart.product_image).into(p0.itemView.imgCart)
    }

    class Myholder3(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}
