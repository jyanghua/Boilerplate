package com.example.boilerplate.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(val id: Int? = null, val listId: Int? = null, val name: String? = null) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if(javaClass != other?.javaClass) return false
        other as Item
        if(id != other.id || listId != other.listId || name != other.name) return false
        return true
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + (listId ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        return result
    }
}
