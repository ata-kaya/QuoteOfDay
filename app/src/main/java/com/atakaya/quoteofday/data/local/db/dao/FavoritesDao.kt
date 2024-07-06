package com.atakaya.quoteofday.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.atakaya.quoteofday.data.local.models.FavoriteDaoModel


@Dao
interface FavoritesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorites(favoriteDaoModel: FavoriteDaoModel)

    @Query("SELECT * FROM fav")
    fun getAllFavorites(): List<FavoriteDaoModel>?
}
