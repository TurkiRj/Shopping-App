package com.example.testingnew.Data

import com.example.testingnew.Model.Product
import com.example.testingnew.Model.Products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrieveProducts {
    val BASE_URL = "https://dummyjson.com/"

    fun retrieveProductsData(): JsonPlaceHolderApi {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JsonPlaceHolderApi::class.java)

        return retrofit as JsonPlaceHolderApi
    }
}