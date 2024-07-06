package com.atakaya.quoteofday.presentation.ui.screens.fav_screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atakaya.quoteofday.domain.usecase.GetAllFavoritesUseCase
import com.atakaya.quoteofday.presentation.ui.models.QuoteModel
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

                }.collect {
                    _favList.value = it
                }
        }
    }
}