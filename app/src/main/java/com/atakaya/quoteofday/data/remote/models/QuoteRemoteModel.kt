package com.atakaya.quoteofday.data.remote.models

import com.google.gson.annotations.SerializedName

data class QuoteRemoteModel(
    @SerializedName("message") var message: String? = null,
    @SerializedName("quote") var quote: Quote? = Quote()
)


data class Quote(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("category") var category: String? = null,
    @SerializedName("quote") var quote: String? = null,
    @SerializedName("author") var author: String? = null,
    @SerializedName("description") var description: String? = null
)
