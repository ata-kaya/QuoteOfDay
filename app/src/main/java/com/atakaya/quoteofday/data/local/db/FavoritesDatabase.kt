package com.atakaya.quoteofday.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.atakaya.quoteofday.data.local.db.dao.FavoritesDao
import com.atakaya.quoteofday.data.local.models.FavoriteDaoModel


@Database(entities = [FavoriteDaoModel::class], version = 1, exportSchema = false)
abstract class FavoritesDatabase : RoomDatabase() {
    abstract fun favoritesDao(): FavoritesDao
}
