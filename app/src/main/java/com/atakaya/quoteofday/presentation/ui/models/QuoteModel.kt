package com.atakaya.quoteofday.presentation.ui.models

import com.atakaya.quoteofday.data.local.models.FavoriteDaoModel
import com.atakaya.quoteofday.data.remote.models.QuoteRemoteModel

data class QuoteModel(
    val quote: String?,
    val author: String?,
    val isFavorite: Boolean = false,
)

fun FavoriteDaoModel.mapFaveDataToQuoteModel(): QuoteModel {
    return QuoteModel(
        quote = this.quote, author = this.author, isFavorite = true
    )
}

fun QuoteRemoteModel.mappedResponseForUI(): QuoteModel {
    return QuoteModel(
        quote = this.quote?.quote, author = this.quote?.author
    )
}
