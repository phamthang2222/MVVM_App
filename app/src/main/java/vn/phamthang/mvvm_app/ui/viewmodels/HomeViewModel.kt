package vn.phamthang.mvvm_app.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response
import vn.phamthang.mvvm_app.api.BaseRespone
import vn.phamthang.mvvm_app.models.ListProductRespone
import vn.phamthang.mvvm_app.respositories.HomeRepository

class HomeViewModel( val homeRepository: HomeRepository, application: Application):AndroidViewModel(application) {

    val listProductResult: MutableLiveData<BaseRespone<ListProductRespone>> = MutableLiveData()
    var listProductRespone: ListProductRespone? = null
    init{
        getListProduct()
    }
    private fun getListProduct(){
        viewModelScope.launch {
            listProductResult.value = BaseRespone.Loading()
            val result = homeRepository.getListProduct()
            listProductResult.postValue(handerListProduct(result))
        }
    }
    private fun handerListProduct(response: Response<ListProductRespone>) : BaseRespone<ListProductRespone> {
        if(response.isSuccessful && response.code() == 200){
            response.body()?.let {data->
                listProductRespone = data
                return BaseRespone.Success(data)
//                return BaseReponse.Success(it)
            }
        }
        return  BaseRespone.Error(null, "Load failed!")
    }

}