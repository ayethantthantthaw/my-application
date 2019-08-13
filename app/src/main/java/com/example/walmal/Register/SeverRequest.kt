package com.example.walmal.Register

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import com.google.gson.Gson



class SeverRequest{
    companion object {
        var gson = GsonBuilder()
            .setLenient()
            .create()
        val retrofitClient = Retrofit.Builder()
            .baseUrl("http://www.walmal.16mb.com/login_api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(Webservice::class.java)

    }
}