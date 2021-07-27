package com.mocky

import android.app.Application
import com.mocky.di.dataSourceModule
import com.mocky.di.networkModule
import com.mocky.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApplication)
            modules(listOf(viewModelModule, dataSourceModule, networkModule))
        }
    }
}