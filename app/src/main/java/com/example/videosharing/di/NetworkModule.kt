package com.example.videosharing.di

import com.google.gson.GsonBuilder
import com.example.videosharing.data.HttpRequestUrl
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECT_TIMEOUT = 20L
private const val WRITE_TIMEOUT = 20L
private const val READ_TIMEOUT = 20L

val networkModule = module {
    single { Cache(androidApplication().cacheDir, 10L * 1024 * 1024) }

    single { GsonBuilder().create() }

    single {
        OkHttpClient.Builder().apply {
            cache(get())
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                    val requestBuilder: Request.Builder = chain.request().newBuilder()
                    requestBuilder.header("Accept", "application/json")

                    return chain.proceed(requestBuilder.build())
                }
            })
        }.build()
    }

    single {
        Retrofit.Builder()
                .baseUrl(HttpRequestUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(get()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(get())
                .build()
    }
}
