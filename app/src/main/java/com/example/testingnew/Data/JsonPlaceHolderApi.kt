package com.example.testingnew.Data

import com.example.testingnew.Model.Products
import retrofit2.http.GET

interface JsonPlaceHolderApi {
    @GET("products")
    suspend fun getProductsApi(): Products
}