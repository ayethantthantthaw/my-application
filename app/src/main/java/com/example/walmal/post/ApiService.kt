package com.example.walmal.post



import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("product.php")
    fun getPosts1(): Call<HomeDataObj>

}

interface ApiService2 {
    @GET("event.php")
    fun getPosts(): Call<DataObj>}

interface CategoriesApiService {
    @GET("category.php")
    fun getPostsc(): Call<CatDataObj>

    @POST("category.php")
    fun getPostsCd(@Query("cat_id") cat: Int): Call<Cat_Detail_DataObject>

}
interface CartApiService{
    
    @FormUrlEncoded
    @POST("cart_view.php")
    fun getPostCart(@Field("cart_product_id")cart_product_id:String):Call<CartDataObj>


}
