package com.example.walmal.post

import com.google.gson.annotations.SerializedName

class DataObj(
    @SerializedName("data")
    val pro : List<Posts2>
)
class CatDataObj(
    @SerializedName("data")
    val prodcat: List<Postsc>

)
class HomeDataObj(
    @SerializedName("data")
    val prodhome : List<Posts>

)
class Cat_Detail_DataObject(
    @SerializedName("data")
    val prodcat_detail:List<PostCd>
)
class CartDataObj(
    @SerializedName("data")
    val cart:List<PostCart>
)
