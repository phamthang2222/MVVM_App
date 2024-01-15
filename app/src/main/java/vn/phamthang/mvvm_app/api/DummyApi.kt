package vn.phamthang.mvvm_app.api

import retrofit2.Response
import retrofit2.http.GET
import vn.phamthang.mvvm_app.models.ListProductRespone

interface DummyApi {
    @GET("/products")
    suspend fun getListProduct():Response<ListProductRespone>
}