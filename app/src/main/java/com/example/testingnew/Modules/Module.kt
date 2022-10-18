package com.example.testingnew.Modules

import com.example.testingnew.Data.JsonPlaceHolderApi
import com.example.testingnew.Repository.Repository
import com.example.testingnew.UI.Main.MainViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@DelicateCoroutinesApi
val retrofitBuilderModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JsonPlaceHolderApi::class.java)
    }
    single {
        Repository(get())
    }
}

@DelicateCoroutinesApi
val modelViewModule = module {
    viewModel { MainViewModel(get()) }
}