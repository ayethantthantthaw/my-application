package com.example.walmal.Register

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Webservice {
    @FormUrlEncoded
    @POST("register.php")
    fun register(
        @Field("name") name:String,
        @Field("email") email:String,
        @Field("password") password:String,
        @Field("confirm_password") confirm_password:String,
        @Field("nrc") nrc:String,
        @Field("phone")phone:String,
        @Field("address") address:String
    ): Call<ServerRespone>

}