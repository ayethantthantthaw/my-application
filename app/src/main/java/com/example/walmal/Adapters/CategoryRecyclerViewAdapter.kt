package com.example.walmal.Adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.walmal.ActivityCart
import com.example.walmal.Product_Detail
import com.example.walmal.R
import com.example.walmal.Objects.Product
import com.example.walmal.post.PostCd
import kotlinx.android.synthetic.main.category_list_item.view.*


class CategoryRecyclerViewAdapter(private var list5: List<PostCd>, private var context: Context?):
    RecyclerView.Adapter<CategoryRecyclerViewAdapter.Myholder5>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Myholder5 {
        val view= LayoutInflater.from(context).inflate(R.layout.category_list_item,p0,false)
        return Myholder5(view)

    }

    override fun getItemCount(): Int{
        return list5.size
    }

    override fun onBindViewHolder(p0: Myholder5, p1: Int) {

        val posts=list5[p1]
        p0.itemView.tvTitle5.text=posts.product_title
        p0.itemView.tvPrice5.text="$"+posts.product_price
       Glide.with(context).load(posts.product_image).into(p0.itemView.tvimage5)

        /*p0.itemView.btn_addToCart5.setOnClickListener {
            val p=Intent(context!!, ActivityCart::class.java)

            Product.id = posts.product_id.toString()
            Product.img=posts.product_image
            Product.title=posts.product_title
            Product.price=posts.product_price
            Product.qty=posts.product_qty
            context!!.startActivity(p) }*/
        p0.itemView.tvimage5.setOnClickListener {
            val p=Intent(context!!, Product_Detail::class.java)

            Product.id = posts.product_id.toString()
            Product.img=posts.product_image
            Product.title=posts.product_title
            Product.price=posts.product_price
            Product.qty=posts.product_qty
            context!!.startActivity(p)
        }

    }


    class Myholder5(itemView: View): RecyclerView.ViewHolder(itemView) {
    }

}
