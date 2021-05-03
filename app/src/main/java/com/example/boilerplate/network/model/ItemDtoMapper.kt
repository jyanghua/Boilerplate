package com.example.boilerplate.network.model

import com.example.boilerplate.domain.model.Item
import com.example.boilerplate.domain.util.DomainMapper

class ItemDtoMapper : DomainMapper<ItemDto, Item> {
    override fun mapToDomainModel(model: ItemDto): Item {
        return Item(
            id = model.id,
            listId = model.listId,
            name = model.name
        )
    }

    override fun mapFromDomainModel(domainModel: Item): ItemDto {
        return ItemDto(
            id = domainModel.id,
            listId = domainModel.listId,
            name = domainModel.name
        )
    }

    fun toDomainList(initial: List<ItemDto>): Map<String, List<Item>> {
        return initial.map {
            mapToDomainModel(it)
        }
            .sortedBy { it.name }
            .filterNot { it.name == null || it.name == "" }
            .groupBy { it.listId.toString() }
    }

    fun fromDomainList(initial: List<Item>): List<ItemDto> {
        return initial.map {
            mapFromDomainModel(it)
        }
    }
}