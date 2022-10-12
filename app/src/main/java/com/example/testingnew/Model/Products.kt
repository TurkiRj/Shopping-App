package com.example.testingnew.Model

import com.google.gson.annotations.SerializedName

class Products {


    @SerializedName("products")
    private var product: List<Product?>? = null

    fun getProduct(): List<Product?>? {
        return product
    }

    fun setProduct(product: List<Product?>?) {
        this.product = product
    }
}