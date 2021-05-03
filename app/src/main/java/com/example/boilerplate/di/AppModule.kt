package com.example.boilerplate.di

import android.content.Context
import com.example.boilerplate.data.ItemRepository
import com.example.boilerplate.presentation.BaseApplication
import com.example.boilerplate.presentation.ui.CategoryListAdapter
import com.example.boilerplate.presentation.ui.ItemListAdapter
import com.example.boilerplate.presentation.ui.itemList.ItemListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }

    @Singleton
    @Provides
    fun categoryListAdapter(
        itemListViewModel: ItemListViewModel,
    ): CategoryListAdapter = CategoryListAdapter(itemListViewModel)

    @Singleton
    @Provides
    fun itemListAdapter(): ItemListAdapter = ItemListAdapter()

    @Singleton
    @Provides
    fun itemListViewModel(itemRepository: ItemRepository): ItemListViewModel =
        ItemListViewModel(itemRepository)

}