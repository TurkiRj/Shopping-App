package com.example.testingnew.Model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("title") val name: String, val description: String,
    val price: Int, @SerializedName("thumbnail") val image: String
)