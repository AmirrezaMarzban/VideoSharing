package com.example.videosharing.di

import com.example.videosharing.data.ApiService
import org.koin.dsl.module.module
import retrofit2.Retrofit

val apiModule = module {
    single(createOnStart = false) { get<Retrofit>().create(ApiService::class.java) }
}