package com.example.boilerplate.network.model

import com.google.gson.annotations.SerializedName

data class ItemDto(

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("listId")
    var listId: Int? = null,

    @SerializedName("name")
    var name: String? = null
)
