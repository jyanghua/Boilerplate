package com.example.boilerplate.presentation.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.boilerplate.data.ItemRepository
import com.example.boilerplate.domain.model.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val itemRepository: ItemRepository) :
    ViewModel() {

    private val _items: MutableLiveData<List<Item>> = MutableLiveData()

    val items: LiveData<List<Item>> get() = _items

    init {
    }
}
