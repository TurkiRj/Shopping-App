package com.example.testingnew.UI.Main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testingnew.Model.Product
import com.example.testingnew.Repository.Repository
import kotlinx.coroutines.DelicateCoroutinesApi


@DelicateCoroutinesApi
class MainViewModel(repository: Repository) : ViewModel() {

    private val _productsMutableLiveData: MutableLiveData<List<Product>>

    val productsLiveData: LiveData<List<Product>>
        get() = _productsMutableLiveData

    init {
        _productsMutableLiveData = repository.getRepositoryLiveData()
    }
}