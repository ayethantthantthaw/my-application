package com.example.walmal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.View
import android.widget.Toast
import com.example.walmal.Adapters.CategoryRecyclerViewAdapter
import com.example.walmal.post.Cat_Detail_DataObject
import com.example.walmal.post.CategoriesApiService
import com.example.walmal.post.PostCd
import kotlinx.android.synthetic.main.activity_categories.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CategoryActivity : AppCompatActivity() {
    lateinit var  cat_detail_List:MutableList<PostCd>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        val cat=intent.getIntExtra("c_id",0)

               cat_detail_List=ArrayList()

        val retrofitClient2= Retrofit.Builder()
            .baseUrl("http://www.walmal.16mb.com/API/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitSercive2=retrofitClient2.create(CategoriesApiService::class.java)
        val retrofitCall2=retrofitSercive2.getPostsCd(cat)

        retrofitCall2.enqueue(object : Callback<Cat_Detail_DataObject>
        {
            override fun onFailure(call: Call<Cat_Detail_DataObject>, t: Throwable) {
                Toast.makeText(this@CategoryActivity,t.message.toString(),Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Cat_Detail_DataObject>, response: Response<Cat_Detail_DataObject>) {


                val p: Cat_Detail_DataObject =response.body()!!
                val prodcd=p.prodcat_detail

                rc5.layoutManager= GridLayoutManager(this@CategoryActivity,2)
                rc5.adapter= CategoryRecyclerViewAdapter(prodcd, this@CategoryActivity)
                progress_category.visibility=View.GONE
            }
       })

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }



}
