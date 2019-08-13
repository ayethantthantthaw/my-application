package com.example.walmal


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.walmal.Adapters.EventRecyclerViewAdapter
import com.example.walmal.post.ApiService2
import com.example.walmal.post.DataObj
import com.example.walmal.post.Posts2
import kotlinx.android.synthetic.main.fragment_event.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Event : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false)
    }
    lateinit var  postList2:MutableList<Posts2>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postList2=ArrayList()

        val retrofitClient2= Retrofit.Builder()
            .baseUrl("http://www.walmal.16mb.com/API/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitSercive2=retrofitClient2.create(ApiService2::class.java)
        val retrofitCall2=retrofitSercive2.getPosts()

       retrofitCall2.enqueue(object : Callback<DataObj>
       {
           override fun onFailure(call: Call<DataObj>, t: Throwable) {

           }

           override fun onResponse(call: Call<DataObj>, response: Response<DataObj>) {


               val p: DataObj=response.body()!!
               val prod=p.pro

               rc3.layoutManager= LinearLayoutManager(activity)
               rc3.adapter= EventRecyclerViewAdapter(prod, context)
               progress_event.visibility=View.GONE
                 } })

    }

}
