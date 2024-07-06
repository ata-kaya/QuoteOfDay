package com.atakaya.quoteofday.domain.repository

import com.atakaya.quoteofday.data.local.models.FavoriteDaoModel
import com.atakaya.quoteofday.data.remote.models.QuoteRemoteModel
import kotlinx.coroutines.flow.Flow

interface FavoritesRepo {
    fun getAllFavesAsListFromLocal(): Flow<List<FavoriteDaoModel>?>
    suspend fun insertFavorite(favoriteDaoModel: FavoriteDaoModel)
    fun getAQuoteOfDay(): Flow<QuoteRemoteModel>
}
