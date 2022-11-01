package com.example.testingnew.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testingnew.R
import com.example.testingnew.UI.Payment.PaymentPage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Product details
        val bundle = intent.extras!!
        val productName = bundle.getString("productName")
        val description = bundle.getString("description")
        val price = bundle.getInt("price")
        val image = bundle.getString("image")

        // Display product details
        tvNameD.text = productName
        tvDesD.text = getString(R.string.Description, description)
        tvPrice.text = getString(R.string.Price, price.toString())
        Picasso.get().load(image).into(ivFoodImageDetails)

        // Pay button listener
        pay.setOnClickListener {
            val intent = Intent(this, PaymentPage::class.java)
            intent.putExtra("price", price.toDouble())
            startActivities(arrayOf(intent))
        }
    }
}