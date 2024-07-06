package com.atakaya.quoteofday.utils

import android.util.Log
import com.atakaya.quoteofday.data.remote.api.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

fun <T> Flow<T>.asResult(): Flow<ApiResult<T>> {
    return this
        .map<T, ApiResult<T>> {
            Log.w("atakaya", "on map")
            ApiResult.Success(it)
        }
        .onStart {
            Log.w("atakaya", "on start")
            emit(ApiResult.Loading)
        }
        .catch {
            Log.w("atakaya", "on error")
            emit(ApiResult.Error(it))
        }
}