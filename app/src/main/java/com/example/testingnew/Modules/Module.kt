package com.example.testingnew.Modules

import com.example.testingnew.Repository.Repository
import com.example.testingnew.UI.Main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val modelViewModule = module {
    viewModel { MainViewModel(get()) }
}

val repositoryModule = module {

    single { Repository() }
}