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
import com.example.testingnew.Repository.Repository
import com.example.testingnew.UI.Details
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), ExampleAdapter.OnItemClickListener {

    var listOfProduct: List<Product> = ArrayList(30)
    val ViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ViewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        ViewModel.productMutableLiveData.observe(this, Observer {
            listOfProduct = it as List<Product>

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
        intent.putExtra("productName", clickedItem.title!!)
        intent.putExtra("image", clickedItem.image!!)
        intent.putExtra("description", clickedItem.description!!)
        intent.putExtra("price", clickedItem.price!!)
        startActivities(arrayOf(intent))
    }
}