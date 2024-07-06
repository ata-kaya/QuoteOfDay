package com.atakaya.quoteofday.domain.usecase

import com.atakaya.quoteofday.data.local.models.FavoriteDaoModel
import com.atakaya.quoteofday.domain.repository.FavoritesRepo
import com.atakaya.quoteofday.presentation.ui.models.QuoteModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllFavoritesUseCase(private val favoritesRepo: FavoritesRepo) :
    UseCase<Flow<List<QuoteModel?>>>() {
    override fun execute(): Flow<List<QuoteModel?>> {
        return favoritesRepo.getAllFavesAsListFromLocal().map(::mapFaveDataToQuoteModel)
    }

    private fun mapFaveDataToQuoteModel(data: List<FavoriteDaoModel>?): List<QuoteModel?> {
        return data?.let { _data ->
            _data.map {
                QuoteModel(
                    quote = it.quote, author = it.author, isFavorite = true
                )
            }
        } ?: run {
            listOf()
        }
    }
}
