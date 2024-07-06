package com.atakaya.quoteofday.data.remote.api

import com.atakaya.quoteofday.data.remote.models.QuoteRemoteModel
import retrofit2.http.GET

interface ApiService {

    @GET("/random")
    suspend fun getAQuote(): QuoteRemoteModel
}
