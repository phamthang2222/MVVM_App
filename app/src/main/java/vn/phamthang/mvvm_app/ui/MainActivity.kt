package vn.phamthang.mvvm_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import vn.phamthang.mvvm_app.R
import vn.phamthang.mvvm_app.api.BaseRespone
import vn.phamthang.mvvm_app.databinding.ActivityMainBinding
import vn.phamthang.mvvm_app.respositories.HomeRepository
import vn.phamthang.mvvm_app.ui.viewmodels.HomeViewModel
import vn.phamthang.mvvm_app.ui.viewmodels.HomeViewModelFactory

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var view = layoutInflater.inflate(R.layout.activity_main,null)
        binding = ActivityMainBinding.bind(view)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.findNavController()
        binding.bottomNavigation.setupWithNavController(navController)

        val HomeRepository = HomeRepository()
        val homeViewModelFactory = HomeViewModelFactory(HomeRepository,application = application)
        val homeViewModel = ViewModelProvider(this, homeViewModelFactory)[HomeViewModel::class.java]

        homeViewModel.listProductResult.observe(this, Observer {
            when(it ){
                is BaseRespone.Success ->{
                    hideLoading()
                    it.data?.let {
                        Log.d(TAG,"onCreate: ${it.products.size}")
                    }

                }

                is BaseRespone.Error ->{
                    hideLoading()
                    Log.d(TAG,"onCreate: ${it.message}")
                }

                is BaseRespone.Loading ->{
                    showLoading()
                }
            }
        })

    }
    private fun hideLoading(){

    }
    private fun showLoading(){

    }

}