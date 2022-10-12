package com.example.testingnew.Model

import com.google.gson.annotations.SerializedName

class Product {

    var id: Int? = null

    private var title: String = ""

    private var description: String? = null

    private var price = 0

    @SerializedName("thumbnail")
    private var image: String? = null

    fun getId(): Int {
        return id!!
    }

    fun getTitle(): String? {
        return title!!
    }

    fun getDescription(): String? {
        return description!!
    }

    fun getPrice(): Int {
        return price!!
    }

    fun getImage(): String {
        return image!!
    }

}