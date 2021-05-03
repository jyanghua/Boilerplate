package com.example.boilerplate.presentation.ui.itemList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.boilerplate.R
import com.example.boilerplate.databinding.FragmentItemListBinding
import com.example.boilerplate.presentation.ui.CategoryListAdapter
import com.example.boilerplate.presentation.ui.ItemListAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemListFragment : Fragment() {

    private lateinit var binding: FragmentItemListBinding

    @Inject
    lateinit var categoryListAdapter: CategoryListAdapter

    @Inject
    lateinit var itemListAdapter: ItemListAdapter

    @Inject
    lateinit var itemListViewModel: ItemListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<RecyclerView>(R.id.rv_items)?.apply {
            setItemListRecyclerView(this)
        }
        view.findViewById<RecyclerView>(R.id.rv_categories)?.apply {
            setCategoryListRecyclerView(this)
        }
        bindViewModel(itemListViewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_list, container, false)
        return binding.root
    }

    private fun setItemListRecyclerView(itemListRV: RecyclerView) {
        itemListRV.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ItemListFragment.context)
            adapter = itemListAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {})
        }
    }

    private fun setCategoryListRecyclerView(categoryListRV: RecyclerView) {
        categoryListRV.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                this@ItemListFragment.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = categoryListAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {})
        }
    }

    private fun bindViewModel(viewModel: ItemListViewModel) {
        // Add binding.vm and any onClick observers
        viewModel.selectedCategory.observe(
            viewLifecycleOwner,
            { viewModel.filter() }
        )

        viewModel.filteredItems.observe(
            viewLifecycleOwner,
            { itemList ->
                if (itemList != null) {
                    itemListAdapter.submitList(itemList.toMutableList())
//                    itemListAdapter.notifyDataSetChanged()
                } else {
                    Log.d("ASDASDASD", "WOW")
                }
            }
        )

        viewModel.listCategories.observe(
            viewLifecycleOwner,
            { categories ->
                categoryListAdapter.updateCategoryList(categories)
            }
        )

        viewModel.isLoading.observe(
            viewLifecycleOwner,
            { isLoading ->
                if (isLoading) {
                    binding.loading.visibility = View.VISIBLE
                    binding.rvCategories.visibility = View.GONE
                    binding.rvItems.visibility = View.GONE
                } else {
                    binding.loading.visibility = View.GONE
                    binding.rvCategories.visibility = View.VISIBLE
                    binding.rvItems.visibility = View.VISIBLE
                }
            }
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ItemListFragment().apply {
            }

        const val TAG = "ItemListFragment"
    }
}