package com.example.testingnew.Data

import com.example.testingnew.Model.Products
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderApi {
    @GET("products")
    fun getPosts(): Call<Products?>?
}