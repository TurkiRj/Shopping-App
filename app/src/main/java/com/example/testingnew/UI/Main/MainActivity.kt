package com.example.testingnew.UI.Main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testingnew.*
import com.example.testingnew.Model.Product
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.ViewModelProvider
import com.example.testingnew.UI.Details
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//ExampleAdapter.OnItemClickListener
class MainActivity : AppCompatActivity(), ExampleAdapter.OnItemClickListener {

    var listOfProduct: List<Product> = ArrayList(30)
    lateinit var ViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        ViewModel.getPosts()


        ViewModel.productMutableLiveData.observe(this, Observer {
            listOfProduct = it as List<Product>
            Log.i("turki", "after load")

            adapter()
        })

    }

    fun adapter() {
        val adapter = ExampleAdapter(listOfProduct, this)
        Log.i("turki", "adapter")
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    override fun onItemClick(position: Int) {
        val clickedItem: Product = listOfProduct[position]
        val intent = Intent(this, Details::class.java)
        intent.putExtra("productName", clickedItem.getTitle()!!)
        intent.putExtra("image", clickedItem.getImage()!!)
        intent.putExtra("description", clickedItem.getDescription()!!)
        intent.putExtra("price", clickedItem.getPrice()!!)
        startActivities(arrayOf(intent))
    }
}