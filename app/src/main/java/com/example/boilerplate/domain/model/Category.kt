package com.example.boilerplate.domain.model

data class Category(val categoryName: String? = null) {
    override fun equals(other: Any?): Boolean {
        if(javaClass != other?.javaClass) return false
        other as Category
        if(categoryName != other.categoryName) return false
        return true
    }

    override fun hashCode(): Int {
        return categoryName?.hashCode() ?: 0
    }
}
