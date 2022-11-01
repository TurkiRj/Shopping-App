package com.example.testingnew.Repository

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.testingnew.Data.JsonPlaceHolderApi
import com.example.testingnew.Model.Product
import kotlinx.coroutines.*

@DelicateCoroutinesApi
class Repository(private val API: JsonPlaceHolderApi) {

    private var repositoryMutableLiveData: MutableLiveData<List<Product>> =
        MutableLiveData<List<Product>>()

    init {
        try {
            GlobalScope.launch(Dispatchers.Main) {
                val response = API.getProductsApi()
                repositoryMutableLiveData.value = response.listOfProduct

            }
        }catch (ex:Exception){
        }
    }

    fun getRepositoryLiveData(): MutableLiveData<List<Product>> {
        return this.repositoryMutableLiveData
    }
}