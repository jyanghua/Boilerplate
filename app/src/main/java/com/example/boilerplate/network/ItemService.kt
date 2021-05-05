package com.example.boilerplate.network

import com.example.boilerplate.network.model.ItemDto
import retrofit2.http.GET
import retrofit2.http.Headers

interface ItemService {

    @GET("hiring.json")
    @Headers("Accept: application/json")
    suspend fun getItems(): List<ItemDto>
}
