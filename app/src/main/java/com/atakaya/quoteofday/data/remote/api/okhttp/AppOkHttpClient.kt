package com.atakaya.quoteofday.data.remote.api.okhttp

import okhttp3.OkHttpClient

interface AppOkHttpClient {
    fun getUnSafeClient(): OkHttpClient
}
