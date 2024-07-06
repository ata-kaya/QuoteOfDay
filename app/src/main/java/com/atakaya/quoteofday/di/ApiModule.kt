package com.atakaya.quoteofday.di

import com.atakaya.quoteofday.BuildConfig
import com.atakaya.quoteofday.data.remote.api.ApiService
import com.atakaya.quoteofday.data.remote.api.okhttp.OkHTTPClientImpl
import com.atakaya.quoteofday.domain.usecase.AddTOFavoritesUseCase
import com.atakaya.quoteofday.domain.usecase.GetAQuoteOfDayUseCase
import com.atakaya.quoteofday.domain.usecase.GetAllFavoritesUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {
    single { OkHTTPClientImpl().getUnSafeClient() }
    single {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = get<OkHttpClient>().newBuilder()
            .addInterceptor(logging)
            .build()

        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)  // Replace with your API base URL
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
    single {
        GetAQuoteOfDayUseCase(get())
    }
    single {
        AddTOFavoritesUseCase(get())
    }
    single {
        GetAllFavoritesUseCase(get())
    }
}
