package vn.phamthang.mvvm_app.api

sealed class BaseRespone<T>(val data: T? = null, val message:String? = null){
    class Success<T>(data: T?):BaseRespone<T>()

    class Error<T>(data:T?, message: String?):BaseRespone<T>(message = message)

    class Loading<T>() : BaseRespone<T>()
}