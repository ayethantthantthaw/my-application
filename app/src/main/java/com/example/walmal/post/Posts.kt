package com.example.walmal.post

//product
data class Posts(val product_id:Int,val product_title:String,val product_image:String,val product_content:String,val product_qty:String,val product_price:String)
//event
data class Posts2(val event_name : String,val description: String ,val start_date:String,val end_date : String , val location : String)
//categories
data class Postsc(var cat_id:Int,var cat_title:String?=null )
//category detail
data class PostCd(val product_id:Int,val cat_id:Int,val product_title:String,val product_qty:String,val product_image:String, val product_price:String)
//cart
data class PostCart(val product_image:String,val seller_name:String,val seller_email:String,val seller_phone_no:String)