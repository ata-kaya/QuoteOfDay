package com.atakaya.quoteofday.domain.usecase

import com.atakaya.quoteofday.data.remote.api.ApiResult
import com.atakaya.quoteofday.data.remote.models.QuoteRemoteModel
import com.atakaya.quoteofday.domain.repository.FavoritesRepo
import com.atakaya.quoteofday.presentation.ui.models.QuoteModel
import com.atakaya.quoteofday.utils.asResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAQuoteOfDayUseCase(private val favoritesRepo: FavoritesRepo) :
    UseCase<Flow<ApiResult<QuoteModel>>>() {
    override fun execute(): Flow<ApiResult<QuoteModel>> {
        return favoritesRepo.getAQuoteOfDay().map(::mappedResponseForUI).asResult()
    }

    private fun mappedResponseForUI(response: QuoteRemoteModel): QuoteModel {
        return QuoteModel(
            quote = response.quote?.quote, author = response.quote?.author
        )
    }
}
