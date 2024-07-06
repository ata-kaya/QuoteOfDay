package com.atakaya.quoteofday.domain.usecase

import com.atakaya.quoteofday.data.local.models.FavoriteDaoModel
import com.atakaya.quoteofday.domain.repository.FavoritesRepo
import com.atakaya.quoteofday.presentation.ui.models.QuoteModel

class AddTOFavoritesUseCase(private val favoritesRepo: FavoritesRepo) :
    ParameterizedSuspendUseCase<QuoteModel>() {
    override suspend fun exec(params: QuoteModel) {
        params.quote?.let {
            favoritesRepo.insertFavorite(
                favoriteDaoModel = FavoriteDaoModel(
                    quote = it,
                    author = params.author ?: "unknown"
                )
            )
        }
    }
}
