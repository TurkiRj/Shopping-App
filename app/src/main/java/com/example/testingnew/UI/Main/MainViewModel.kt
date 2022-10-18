package com.example.testingnew.UI.Main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testingnew.Model.Product
import com.example.testingnew.Repository.Repository
import kotlinx.coroutines.DelicateCoroutinesApi


@DelicateCoroutinesApi
class MainViewModel(private val repository: Repository) : ViewModel() {

    private val _productsMutableLiveData: MutableLiveData<List<Product>> =
        repository.getRepositoryLiveData()

    val productsLiveData: LiveData<List<Product>>
        get() = _productsMutableLiveData
}