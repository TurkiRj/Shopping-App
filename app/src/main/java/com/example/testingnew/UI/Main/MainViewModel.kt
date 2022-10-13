package com.example.testingnew.UI.Main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testingnew.Data.RetrieveProducts
import com.example.testingnew.Model.Product
import com.example.testingnew.Model.Products
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*

class MainViewModel : ViewModel() {

    var productMutableLiveData: MutableLiveData<List<Product?>?> =
        MutableLiveData<List<Product?>?>()

    private val retrieveProductsData = RetrieveProducts().retrieveProductsData()


    fun loadProductsData() {
        viewModelScope.launch(Dispatchers.Main) {
            val response = retrieveProductsData.getProductsApi()!!
            if (response.isSuccessful) {
                productMutableLiveData.value = response!!.body()!!.getProduct()
            }

        }
    }
}
