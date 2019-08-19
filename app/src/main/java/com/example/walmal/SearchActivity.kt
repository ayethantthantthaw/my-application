package com.example.walmal

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.example.walmal.Adapters.RecyclerViewAdapter
import com.example.walmal.Adapters.SearchRecyclerAdapter
import com.example.walmal.post.*
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchActivity : AppCompatActivity() {
    lateinit var searchList: MutableList<Posts>
    lateinit var adapter: SearchRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        edtSearch.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                search(edtSearch.text.toString())
            }

        })


    }

    fun search(txtSearch: String?) {
        searchList = ArrayList()
        adapter = SearchRecyclerAdapter(searchList)

        val retrofitClient2 = Retrofit.Builder()
            .baseUrl("http://www.walmal.16mb.com/API/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitSercive2 = retrofitClient2.create(SearchApiService::class.java)
        val retrofitCall2 = retrofitSercive2.getSearch(txtSearch!!)

        retrofitCall2.enqueue(object : Callback<SearchDataObj> {
            override fun onFailure(call: Call<SearchDataObj>, t: Throwable) {

            }

            override fun onResponse(call: Call<SearchDataObj>, response: Response<SearchDataObj>) {


                val p: SearchDataObj? = response.body()
                if (p!!.searchList == null) {
                    rvSearch.visibility = View.GONE
                    Toast.makeText(this@SearchActivity, "No Item found,Please Try Again!", Toast.LENGTH_LONG).show()
                } else {
                    val searchList: List<Posts>? = p.searchList
                    rvSearch.visibility = View.VISIBLE
                    rvSearch.layoutManager = LinearLayoutManager(this@SearchActivity, LinearLayout.VERTICAL, false)
                    rvSearch.adapter = SearchRecyclerAdapter(searchList!!)
                    adapter.notifyDataSetChanged()
                }

            }

        })
    }

}
