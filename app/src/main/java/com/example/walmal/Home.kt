package com.example.walmal

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.walmal.Adapters.CategoriesListRecyclerViewAdapter
import com.example.walmal.Adapters.RecyclerViewAdapter
import com.example.walmal.post.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Home : Fragment() {
    lateinit var viewflipper:ViewFlipper
    val image= intArrayOf(R.drawable.carousel,R.drawable.wmm,R.drawable.bbwm)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)



    }
    lateinit var  postList:MutableList<Posts>
    lateinit var  catList:MutableList<Postsc>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//slideshow
    viewflipper=view.findViewById(R.id.flipper)
        for (i in 0 until image.size){
            flip_image(image[i])
        }




        postList=ArrayList()

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


                rc7.layoutManager= GridLayoutManager(activity!!,2)
                rc7.adapter= RecyclerViewAdapter(prod, context)


            }

        })
        catList=ArrayList()

        val retrofitClient=Retrofit.Builder()
            .baseUrl("http://www.walmal.16mb.com/API/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitSercive=retrofitClient.create(CategoriesApiService::class.java)
        val retrofitCall=retrofitSercive.getPostsc()
        retrofitCall.enqueue(object:Callback<CatDataObj>{
            override fun onFailure(p0: Call<CatDataObj>, p1: Throwable) {
            }

            override fun onResponse(p0: Call<CatDataObj>, p1: Response<CatDataObj>) {
                val p: CatDataObj =p1.body()!!
                val prodcat=p.prodcat


                rc_categories.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                rc_categories.adapter= CategoriesListRecyclerViewAdapter(prodcat, context)

            }
        })

    }

    fun flip_image(i: Int){
        val view=ImageView(activity)
        view.setBackgroundResource(i)
        viewflipper.addView(view)
        viewflipper.setFlipInterval(2000)
        viewflipper.isAutoStart=true
        viewflipper.setInAnimation(activity,android.R.anim.slide_in_left)
        viewflipper.setOutAnimation(activity,android.R.anim.slide_out_right)

    }

}




