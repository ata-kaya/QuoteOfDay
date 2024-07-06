package com.atakaya.quoteofday.presentation

import android.app.Application
import com.atakaya.quoteofday.di.apiModule
import com.atakaya.quoteofday.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApp)
            modules(appModule + apiModule)
        }
    }
}
