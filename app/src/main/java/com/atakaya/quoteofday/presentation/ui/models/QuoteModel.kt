package com.atakaya.quoteofday.presentation.ui.models

data class QuoteModel(
    val quote: String?,
    val author: String?,
    val isFavorite: Boolean = false,
)
