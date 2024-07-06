package com.atakaya.quoteofday.presentation.ui.screens.main_screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atakaya.quoteofday.data.remote.api.ApiResult
import com.atakaya.quoteofday.domain.usecase.AddTOFavoritesUseCase
import com.atakaya.quoteofday.domain.usecase.GetAQuoteOfDayUseCase
import com.atakaya.quoteofday.presentation.ui.models.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MainViewModel(
    private val getAQuoteOfDayUseCase: GetAQuoteOfDayUseCase,
    private val addTOFavoritesUseCase: AddTOFavoritesUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<ApiResult<QuoteModel>>(ApiResult.Loading)
    val uiState = _uiState.asStateFlow()

    private val _shareText = MutableStateFlow<String?>(null)
    val shareText = _shareText.asStateFlow()


    fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            getAQuoteOfDayUseCase.execute().catch {}.collect {
                    _uiState.value = it
                }

        }
    }

    fun addToFavorite(quoteModel: ApiResult.Success<QuoteModel>) {
        val currentState = _uiState.value
        if (currentState is ApiResult.Success) {
            val updated = currentState.data.copy(isFavorite = quoteModel.data.isFavorite.not())
            _uiState.value = ApiResult.Success(updated)
        }
        viewModelScope.launch {
            addTOFavoritesUseCase.exec(quoteModel.data)
        }
    }

    fun openShareModalVia(quoteModel: QuoteModel) {
        _shareText.value = "${quoteModel.quote} \"${quoteModel.author}\""
    }

    fun clearShareText() {
        _shareText.value = null
    }

}
