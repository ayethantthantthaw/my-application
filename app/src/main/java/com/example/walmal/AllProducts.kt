package com.example.walmal
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.walmal.Adapters.RecyclerViewAdapter
import com.example.walmal.post.ApiService
import com.example.walmal.post.HomeDataObj
import com.example.walmal.post.Posts
import kotlinx.android.synthetic.main.fragment_all_product.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AllProducts : Fragment() {
    lateinit var  postList2:MutableList<Posts>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_product, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postList2=ArrayList()

        val retrofitClient2= Retrofit.Builder()
            .baseUrl("http://www.walmal.16mb.com/API/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitSercive2=retrofitClient2.create(ApiService::class.java)
        val retrofitCall2=retrofitSercive2.getPosts1()

        retrofitCall2.enqueue(object : Callback<HomeDataObj>
        {
            override fun onFailure(call: Call<HomeDataObj>, t: Throwable) {

            }

            override fun onResponse(call: Call<HomeDataObj>, response: Response<HomeDataObj>) {


                val p: HomeDataObj =response.body()!!
                val prod=p.prodhome
                progress_home.visibility=View.INVISIBLE

//               val recyclerViewAdapter2=EventRecyclerViewAdapter(prod,this@Event)
                rc4.layoutManager= GridLayoutManager(activity!!,2)
//               rc3.adapter=recyclerViewAdapter2
                rc4.adapter= RecyclerViewAdapter(prod, context)


            }

        })


    }
}
