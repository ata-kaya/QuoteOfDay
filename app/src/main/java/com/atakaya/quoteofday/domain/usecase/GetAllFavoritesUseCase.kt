package com.atakaya.quoteofday.domain.usecase

import com.atakaya.quoteofday.data.local.models.FavoriteDaoModel
import com.atakaya.quoteofday.data.remote.api.ApiResult
import com.atakaya.quoteofday.domain.repository.FavoritesRepo
import kotlinx.coroutines.flow.Flow

class GetAllFavoritesUseCase(private val favoritesRepo: FavoritesRepo) :
    UseCase<Flow<ApiResult<List<FavoriteDaoModel>?>>>() {
    override fun execute(): Flow<ApiResult<List<FavoriteDaoModel>?>> {
        return favoritesRepo.getAllFavesAsListFromLocal()
    }
}
