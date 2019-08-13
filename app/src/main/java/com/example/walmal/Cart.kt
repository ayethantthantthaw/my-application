package com.example.walmal
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.walmal.Adapters.CartRecyclerViewAdapter
import com.example.walmal.post.CartApiService
import com.example.walmal.post.CartDataObj
import com.example.walmal.post.PostCart
import kotlinx.android.synthetic.main.fragment_cart.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Cart : Fragment() {

    lateinit var  postList2:MutableList<PostCart>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postList2=ArrayList()

        val retrofitClient2= Retrofit.Builder()
            .baseUrl("http://www.walmal.16mb.com/login_api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitSercive2=retrofitClient2.create(CartApiService::class.java)
        val retrofitCall2=retrofitSercive2.getPostCart("0")

        retrofitCall2.enqueue(object : Callback<CartDataObj>
        {
            override fun onFailure(call: Call<CartDataObj>, t: Throwable) {


            }

            override fun onResponse(call: Call<CartDataObj>, response: Response<CartDataObj>) {


                val p: CartDataObj =response.body()!!
                val prodCart=p.cart
               // progress_home.visibility=View.INVISIBLE

//               val recyclerViewAdapter2=EventRecyclerViewAdapter(prod,this@Event)
                rc3.layoutManager= GridLayoutManager(activity!!,2)
//               rc3.adapter=recyclerViewAdapter2
                rc3.adapter= CartRecyclerViewAdapter(prodCart, context)


            }

        })


    }
}
