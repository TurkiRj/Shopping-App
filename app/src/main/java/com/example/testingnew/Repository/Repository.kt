package com.example.testingnew.Repository

import androidx.lifecycle.MutableLiveData
import com.example.testingnew.Data.JsonPlaceHolderApi
import com.example.testingnew.Model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {

    private val BASE_URL = "https://dummyjson.com/"

    private var repositoryLiveData: MutableLiveData<List<Product?>?> =
        MutableLiveData<List<Product?>?>()


    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JsonPlaceHolderApi::class.java)

        GlobalScope.launch(Dispatchers.Main) {
            val response = retrofit.getProductsApi()
            repositoryLiveData.value = response.listOfProduct

        }
    }

    fun getRepositoryLiveData(): MutableLiveData<List<Product?>?> {
        return this.repositoryLiveData
    }

}