package com.example.walmal.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.walmal.R
import com.example.walmal.post.PostCart
import com.example.walmal.post.Posts2

class CommentRecyclerViewAdapter(private var list3: List<PostCart>, private var context: Context?):
    RecyclerView.Adapter<CommentRecyclerViewAdapter.Myholder3>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Myholder3 {
        val view= LayoutInflater.from(context).inflate(R.layout.list_item_comment,p0,false)
        return Myholder3(view)

    }

    override fun getItemCount(): Int{
        return list3.size
    }

    override fun onBindViewHolder(p0: Myholder3, p1: Int) {

    }

    class Myholder3(itemView: View): RecyclerView.ViewHolder(itemView) {}

}
