package com.example.boilerplate.data

import com.example.boilerplate.domain.model.Item
import com.example.boilerplate.network.ItemService
import com.example.boilerplate.network.model.ItemDtoMapper

interface ItemRepository {
    suspend fun getItems(): Map<String, List<Item>>
}

class ItemRepositoryImpl(
    private val itemService: ItemService,
    private val mapper: ItemDtoMapper
) :
    ItemRepository {
    override suspend fun getItems(): Map<String, List<Item>> {
        val result = itemService.getItems()
        return mapper.toDomainList(result)
    }
}