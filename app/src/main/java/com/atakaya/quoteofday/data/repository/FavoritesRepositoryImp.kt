package com.atakaya.quoteofday.data.repository

import com.atakaya.quoteofday.data.local.db.dao.FavoritesDao
import com.atakaya.quoteofday.data.local.models.FavoriteDaoModel
import com.atakaya.quoteofday.data.remote.api.ApiService
import com.atakaya.quoteofday.data.remote.models.QuoteRemoteModel
import com.atakaya.quoteofday.domain.repository.FavoritesRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FavoritesRepositoryImp(
    private val favoritesDao: FavoritesDao,
    private val apiService: ApiService,
) : FavoritesRepo {
    override fun getAllFavesAsListFromLocal(): Flow<List<FavoriteDaoModel>?> {
        return flow {
            emit(favoritesDao.getAllFavorites())
        }
    }

    override suspend fun insertFavorite(favoriteDaoModel: FavoriteDaoModel) {
        favoritesDao.addToFavorites(
            FavoriteDaoModel(
                id = favoriteDaoModel.id,
                quote = favoriteDaoModel.quote,
                author = favoriteDaoModel.author
            )
        )
    }

    override fun getAQuoteOfDay(): Flow<QuoteRemoteModel> {
        return flow {
            emit(apiService.getAQuote())
        }
    }
}
