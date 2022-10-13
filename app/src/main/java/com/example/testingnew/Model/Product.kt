package com.example.testingnew.Model

import com.google.gson.annotations.SerializedName

data class Product(
    var id: Int, var title: String, var description: String,
    var price: Int, @SerializedName("thumbnail") var image: String
)