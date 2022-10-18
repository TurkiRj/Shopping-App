package com.example.testingnew.UI.Main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testingnew.*
import com.example.testingnew.Model.Product
import kotlinx.android.synthetic.main.activity_main.*
import com.example.testingnew.UI.Details
import kotlinx.coroutines.DelicateCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel

@DelicateCoroutinesApi
class MainActivity : AppCompatActivity(), ExampleAdapter.OnItemClickListener {

    var listOfProduct: List<Product> = ArrayList(30)

    val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel.productsLiveData.observe(this, Observer {
            listOfProduct = it

            adapter()
        })

    }

    fun adapter() {
        val adapter = ExampleAdapter(listOfProduct, this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {
        val clickedItem: Product = listOfProduct[position]
        val intent = Intent(this, Details::class.java)
        intent.putExtra("productName", clickedItem.name)
        intent.putExtra("image", clickedItem.image)
        intent.putExtra("description", clickedItem.description)
        intent.putExtra("price", clickedItem.price)
        startActivities(arrayOf(intent))
    }
}