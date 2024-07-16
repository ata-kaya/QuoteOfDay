package com.atakaya.quoteofday.domain.repository

import com.atakaya.quoteofday.data.local.models.FavoriteDaoModel
import com.atakaya.quoteofday.data.remote.api.ApiResult
import com.atakaya.quoteofday.data.remote.models.QuoteRemoteModel
import kotlinx.coroutines.flow.Flow

interface FavoritesRepo {
    fun getAllFavesAsListFromLocal(): Flow<ApiResult<List<FavoriteDaoModel>?>>
    suspend fun insertFavorite(favoriteDaoModel: FavoriteDaoModel)
    fun getAQuoteOfDay(): Flow<ApiResult<QuoteRemoteModel>>
}
