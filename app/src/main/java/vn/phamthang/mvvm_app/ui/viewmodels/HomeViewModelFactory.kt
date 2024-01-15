package vn.phamthang.mvvm_app.ui.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import vn.phamthang.mvvm_app.respositories.HomeRepository


class HomeViewModelFactory(private val homeRepository: HomeRepository, private val application: Application):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel( homeRepository = homeRepository,application = application) as T
    }
}