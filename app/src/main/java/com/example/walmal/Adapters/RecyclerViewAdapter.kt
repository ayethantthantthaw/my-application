package com.example.walmal.Adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.walmal.ActivityCart
import com.example.walmal.Product_Detail
import com.example.walmal.R
import com.example.walmal.Objects.Product
import com.example.walmal.post.Posts
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerViewAdapter(private var list: List<Posts>, private var context: Context?):
    RecyclerView.Adapter<RecyclerViewAdapter.Myholder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Myholder {
        val view= LayoutInflater.from(p0.context).inflate(R.layout.list_item,p0,false)
        return Myholder(view)

    }

    override fun getItemCount(): Int{
        return list.size
    }

    override fun onBindViewHolder(p0: Myholder, p1: Int) {
        val posts=list[p1]
        p0.itemView.tvTitle.text=posts.product_title
        p0.itemView.tvPrice.text="$"+posts.product_price

      // Picasso.get().load(posts.product_image).into(p0.itemView.tvimage)
       // p0.title.text=posts.content
       Glide.with(context).load(posts.product_image).into(p0.itemView.tvimage)
//        p0.itemView.btn_addToCart.setOnClickListener {
//            val p=Intent(context!!, ActivityCart::class.java)
//
//            Product.id = posts.product_id.toString()
//            Product.img=posts.product_image
//            Product.title=posts.product_title
//            Product.price=posts.product_price
//            Product.qty=posts.product_qty
//            Product.product_content=posts.product_content
//            context!!.startActivity(p)
//            //Toast.makeText(context,"Added to cart successfully!",Toast.LENGTH_SHORT).show()
//        }

        p0.itemView.tvimage.setOnClickListener {
            val p=Intent(context!!, Product_Detail::class.java)

            Product.id = posts.product_id.toString()
            Product.img=posts.product_image
            Product.title=posts.product_title
            Product.price=posts.product_price
            Product.qty=posts.product_qty
            Product.product_content=posts.product_content
            context!!.startActivity(p)
        }


    }

    class Myholder(itemView: View): RecyclerView.ViewHolder(itemView) {}
    companion object {
        var p_id="p_id"
    }
}
