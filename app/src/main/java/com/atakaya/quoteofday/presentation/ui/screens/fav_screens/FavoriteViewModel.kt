package com.atakaya.quoteofday.presentation.ui.screens.fav_screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atakaya.quoteofday.data.remote.api.ApiResult
import com.atakaya.quoteofday.domain.usecase.GetAllFavoritesUseCase
import com.atakaya.quoteofday.presentation.ui.models.QuoteModel
import com.atakaya.quoteofday.presentation.ui.models.mapFaveDataToQuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val getAllFavoritesUseCase: GetAllFavoritesUseCase
) : ViewModel() {

    private val _favList = MutableStateFlow<List<QuoteModel?>>(listOf())
    val favList = _favList.asStateFlow()

    fun getAllFaves() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllFavoritesUseCase.execute().catch {

            }.collect { response ->
                when (response) {
                    is ApiResult.Error -> {

                    }

                    ApiResult.Loading -> {

                    }

                    is ApiResult.Success -> {
                        _favList.value = response.data?.let { _data ->
                            _data.map {
                                it.mapFaveDataToQuoteModel()
                            }
                        } ?: run { listOf() }
                    }
                }
            }
        }
    }
}
