package com.salamhack.di

import com.salamhack.data.source.remote.home.api.HomeApiService
import com.salamhack.data.source.remote.transaction.api.TransactionApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://modaberbackend.sell-io.app/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<HomeApiService> {
        get<Retrofit>().create(HomeApiService::class.java)
    }
    single<TransactionApiService> {
        get<Retrofit>().create(TransactionApiService::class.java)
    }
}