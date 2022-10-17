package com.example.testingnew.UI.Main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testingnew.Model.Product
import com.example.testingnew.Repository.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {

    var productMutableLiveData: MutableLiveData<List<Product?>?> =
        MutableLiveData<List<Product?>?>()

    init {
        productMutableLiveData = repository.getRepositoryLiveData()
    }
}
