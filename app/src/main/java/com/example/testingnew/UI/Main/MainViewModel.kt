package com.example.testingnew.UI.Main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testingnew.Data.RetrieveProducts
import com.example.testingnew.Model.Product
import com.example.testingnew.Model.Products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    var productMutableLiveData: MutableLiveData<List<Product?>?> =
        MutableLiveData<List<Product?>?>()

    private val retrieveProductsData = RetrieveProducts().retrieveProductsData()


    fun getPosts() {
        val call = retrieveProductsData.getPosts()
        call!!.enqueue(object : Callback<Products?> {

            override fun onResponse(call: Call<Products?>, response: Response<Products?>) {
                if (!response.isSuccessful) {
                    return
                }
                productMutableLiveData.value = response.body()!!.getProduct()
            }

            override fun onFailure(call: Call<Products?>, t: Throwable) {
                TODO("Not yet implemented")
                // we have to put Toast statement here
            }
        })
    }
}
