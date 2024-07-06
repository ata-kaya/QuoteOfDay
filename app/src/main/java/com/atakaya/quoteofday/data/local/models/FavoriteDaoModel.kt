package com.atakaya.quoteofday.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "fav")
data class FavoriteDaoModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val quote: String,
    val author: String
)
