package com.example.walmal.Adapters
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.walmal.Categories
import com.example.walmal.R
import com.example.walmal.post.Postsc
import kotlinx.android.synthetic.main.categories_list_item.view.*


class Categories_RecyclerViewAdapter(private var listc: List<Postsc>,private var context:Context?):
    RecyclerView.Adapter<Categories_RecyclerViewAdapter.Myholderc>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Myholderc {
        val view=LayoutInflater.from(p0.context).inflate(R.layout.categories_list_item,p0,false)
        return Myholderc(view)

    }

    override fun getItemCount(): Int{
        return listc.size
    }

    override fun onBindViewHolder(p0: Myholderc, p1: Int) {
       val postsc=listc[p1]
        p0.title.text=postsc.cat_title

        p0.itemView.tv_categories.setOnClickListener {
           val c= Intent(context!!, Categories::class.java)
            c.putExtra("c_id",postsc.cat_id)
            context!!.startActivity(c)
        }




    }

    class Myholderc(itemView:View):RecyclerView.ViewHolder(itemView) {
        var title:TextView=itemView.findViewById(R.id.tv_categories)as TextView
        //var url:ImageView=itemView.findViewById(R.id.image)as ImageView



    }
    companion object {
        var c_id="c_id"
    }

}
