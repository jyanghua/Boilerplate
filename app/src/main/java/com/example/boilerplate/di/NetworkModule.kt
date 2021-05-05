package com.example.boilerplate.di

import com.example.boilerplate.network.ItemService
import com.example.boilerplate.network.model.ItemDtoMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideItemMapper(): ItemDtoMapper {
        return ItemDtoMapper()
    }

    @Singleton
    @Provides
    fun provideItemService(): ItemService {
        return Retrofit.Builder()
            .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ItemService::class.java)
    }
}
