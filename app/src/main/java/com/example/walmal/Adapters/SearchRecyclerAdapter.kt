package com.example.walmal.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.walmal.R
import com.example.walmal.post.Posts
import kotlinx.android.synthetic.main.item_view_search.view.*

class SearchRecyclerAdapter(var searchList: List<Posts>) :
    RecyclerView.Adapter<SearchRecyclerAdapter.SearchViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SearchViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_view_search, p0, false)
        return SearchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return searchList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(searchList[position])
    }


    class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(posts: Posts) {
            itemView.tvProductName.text = posts.product_title
            itemView.tvProductPrice.text = "$" + posts.product_price
            Glide.with(itemView.context).load(posts.product_image).into(itemView.ivProduct)

        }

    }

}