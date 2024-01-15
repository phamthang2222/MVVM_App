package vn.phamthang.mvvm_app.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import vn.phamthang.mvvm_app.utils.Constants

class RetrofitClient {
    companion object{
        private val instantces by lazy{
            if(Constants.BEBUG == true){
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                val okHttpClient  = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
                Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()

            }else{
                Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
        }

        val getDummyApi = instantces.create(DummyApi::class.java)
    }
}