package com.example.testingnew.UI.Main

import android.app.Application
import com.example.testingnew.Modules.modelViewModule

import com.example.testingnew.Modules.retrofitBuilderModule
import kotlinx.coroutines.DelicateCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application: Application() {

    @DelicateCoroutinesApi
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)

            modules(modelViewModule, retrofitBuilderModule)
        }
    }
}