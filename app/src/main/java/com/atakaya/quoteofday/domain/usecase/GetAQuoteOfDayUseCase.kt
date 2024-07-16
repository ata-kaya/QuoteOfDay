package com.atakaya.quoteofday.domain.usecase

import com.atakaya.quoteofday.data.remote.api.ApiResult
import com.atakaya.quoteofday.data.remote.models.QuoteRemoteModel
import com.atakaya.quoteofday.domain.repository.FavoritesRepo
import kotlinx.coroutines.flow.Flow

class GetAQuoteOfDayUseCase(private val favoritesRepo: FavoritesRepo) :
    UseCase<Flow<ApiResult<QuoteRemoteModel>>>() {
    override fun execute(): Flow<ApiResult<QuoteRemoteModel>> {
        return favoritesRepo.getAQuoteOfDay()
    }
}
