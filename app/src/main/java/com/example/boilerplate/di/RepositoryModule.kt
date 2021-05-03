package com.example.boilerplate.di

import com.example.boilerplate.data.ItemRepository
import com.example.boilerplate.data.ItemRepositoryImpl
import com.example.boilerplate.network.ItemService
import com.example.boilerplate.network.model.ItemDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideItemRepository(
        itemService: ItemService,
        recipeDtoMapper: ItemDtoMapper
    ): ItemRepository {
        return ItemRepositoryImpl(itemService, recipeDtoMapper)
    }
}