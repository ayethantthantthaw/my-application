package com.example.walmal.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.walmal.R
import com.example.walmal.post.Posts2
import kotlinx.android.synthetic.main.list_item3.view.*

class EventRecyclerViewAdapter(private var list3: List<Posts2>, private var context: Context?):
    RecyclerView.Adapter<EventRecyclerViewAdapter.Myholder3>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Myholder3 {
        val view= LayoutInflater.from(context).inflate(R.layout.list_item3,p0,false)
        return Myholder3(view)

    }

    override fun getItemCount(): Int{
        return list3.size
    }

    override fun onBindViewHolder(p0: Myholder3, p1: Int) {
        val posts=list3[p1]

        p0.itemView.event_name.text=posts.event_name
        p0.itemView.description.text=posts.description
        p0.itemView.end_date.text=posts.end_date
        p0.itemView.location.text=posts.location
        p0.itemView.start_date.text=posts.start_date+" to"

    }

    class Myholder3(itemView: View): RecyclerView.ViewHolder(itemView) {    }

}
