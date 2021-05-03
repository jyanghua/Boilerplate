package com.example.boilerplate.presentation.ui.itemList

import android.accounts.NetworkErrorException
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boilerplate.data.ItemRepository
import com.example.boilerplate.domain.model.Category
import com.example.boilerplate.domain.model.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemListViewModel @Inject constructor(private val itemRepository: ItemRepository) :
    ViewModel() {

    private val _groupedItems: MutableLiveData<Map<String, List<Item>>> = MutableLiveData()
    private val _categories: MutableLiveData<List<Category>> = MutableLiveData()
    private val _filteredItems: MutableLiveData<List<Item>> = MutableLiveData()

    val isLoading = MutableLiveData(false)
    val listCategories: LiveData<List<Category>> = _categories
    val selectedCategory: MutableLiveData<String> = MutableLiveData()
    val filteredItems: LiveData<List<Item>> = _filteredItems

    private fun fetchData() {
        try {
            viewModelScope.launch(IO) {
                isLoading.postValue(true)
                _groupedItems.postValue(itemRepository.getItems().also {
                    _categories.postValue(it.keys.map { category ->
                        Category(categoryName = category)
                    }.sortedBy { category -> category.categoryName })
                })
            }.invokeOnCompletion {
                selectedCategory.postValue(_categories.value?.first()?.categoryName)
                filter()
                isLoading.postValue(false)
            }
        } catch (e: Exception) {
            throw NetworkErrorException("Network error", e)
        }
    }

    fun filter() {
        _filteredItems.postValue(_groupedItems.value?.get(selectedCategory.value))
    }

    init {
        fetchData()
    }
}