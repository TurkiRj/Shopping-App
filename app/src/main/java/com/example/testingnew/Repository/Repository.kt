package com.example.testingnew.Repository

import androidx.lifecycle.MutableLiveData
import com.example.testingnew.Data.JsonPlaceHolderApi
import com.example.testingnew.Model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Repository(private val API: JsonPlaceHolderApi) {

    private var repositoryLiveData: MutableLiveData<List<Product?>?> =
        MutableLiveData<List<Product?>?>()


    init {
        GlobalScope.launch(Dispatchers.Main) {
            val response = API.getProductsApi()
            repositoryLiveData.value = response.listOfProduct
        }
    }

    fun getRepositoryLiveData(): MutableLiveData<List<Product?>?> {
        return this.repositoryLiveData
    }

}