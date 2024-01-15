package vn.phamthang.mvvm_app.models


import com.google.gson.annotations.SerializedName

data class ListProductRespone(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("products")
    val products: List<Product>,
    @SerializedName("skip")
    val skip: Int,
    @SerializedName("total")
    val total: Int
)