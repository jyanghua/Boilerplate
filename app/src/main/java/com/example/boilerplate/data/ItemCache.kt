package com.example.boilerplate.data

import com.example.boilerplate.domain.model.Category
import com.example.boilerplate.domain.model.Item

interface ItemCache {
    fun saveGroupedItems(groupedItems: Map<Int?, List<Item>>)
    fun loadGroupedItems(): Map<Int?, List<Item>>
    fun saveCategories(categories: List<Category>)
    fun loadCategories(): List<Category>
}

class ItemTempCache : ItemCache {
    private val groupedItemsMap = hashMapOf<Int?, List<Item>>()
    private val categoriesList = mutableListOf<Category>()

    override fun saveGroupedItems(groupedItems: Map<Int?, List<Item>>) {
        TODO("Not yet implemented")
    }

    override fun loadGroupedItems(): Map<Int?, List<Item>> {
        TODO("Not yet implemented")
    }

    override fun saveCategories(categories: List<Category>) {
        TODO("Not yet implemented")
    }

    override fun loadCategories(): List<Category> {
        TODO("Not yet implemented")
    }
}
