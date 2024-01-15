package vn.phamthang.mvvm_app.respositories

import vn.phamthang.mvvm_app.api.RetrofitClient

class HomeRepository {
    suspend fun getListProduct() = RetrofitClient.getDummyApi.getListProduct()
}