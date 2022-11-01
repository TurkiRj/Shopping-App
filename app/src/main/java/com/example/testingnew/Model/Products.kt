package com.example.testingnew.Model

import com.google.gson.annotations.SerializedName


data class Products(@SerializedName("products") val listOfProduct: List<Product>)