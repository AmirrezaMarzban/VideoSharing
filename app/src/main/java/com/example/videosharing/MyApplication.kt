package com.example.videosharing

import android.app.Application
import com.example.videosharing.di.apiModule
import com.example.videosharing.di.networkModule
import com.example.videosharing.di.viewModelModule
import org.koin.android.ext.android.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(
                apiModule,
                networkModule,
                viewModelModule
            )
        )
    }
}