package com.example.videosharing.di

import com.example.videosharing.viewmodel.ViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { ViewModel(get(), androidContext()) }
}