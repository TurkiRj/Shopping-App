package com.example.testingnew.Model

import com.google.gson.annotations.SerializedName

data class Products(@SerializedName("products") var listOfProduct: List<Product?>? = null)