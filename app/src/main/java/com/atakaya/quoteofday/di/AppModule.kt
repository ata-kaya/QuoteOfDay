package com.atakaya.quoteofday.di

import androidx.room.Room
import com.atakaya.quoteofday.data.local.db.FavoritesDatabase
import com.atakaya.quoteofday.data.repository.FavoritesRepositoryImp
import com.atakaya.quoteofday.domain.repository.FavoritesRepo
import com.atakaya.quoteofday.presentation.ui.screens.fav_screens.FavoriteViewModel
import com.atakaya.quoteofday.presentation.ui.screens.main_screens.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            get(),
            FavoritesDatabase::class.java,
            "fav_database"
        ).build()
    }

    single { get<FavoritesDatabase>().favoritesDao() }

    single<FavoritesRepo> { FavoritesRepositoryImp(get(), get()) }

    viewModel { MainViewModel(get(), get()) }
    viewModel { FavoriteViewModel(get()) }
}
