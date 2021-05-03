package com.example.boilerplate.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.boilerplate.R
import com.example.boilerplate.domain.model.Category
import com.example.boilerplate.presentation.ui.itemList.ItemListViewModel

class CategoryListAdapter(
    private val viewModel: ItemListViewModel,
) :
    RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {
    private val categoryList: MutableList<Category> = mutableListOf()
    private var rowIndex: Int = -1

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvCategory: TextView by lazy { view.findViewById(R.id.tv_category) }
        val ivImage: ImageView by lazy { view.findViewById(R.id.iv_image) }
        val linearLayout: LinearLayout by lazy { view.findViewById(R.id.linearLayout) }
    }

    fun updateCategoryList(categories: List<Category>) {
        rowIndex = 0
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(
            ItemDiffCallback(
                categoryList,
                categories
            )
        )
        categoryList.clear()
        categoryList.addAll(categories)
        diffResult.dispatchUpdatesTo(this)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val categoryInfo = categoryList[position]
        viewHolder.tvCategory.text = categoryInfo.categoryName

        viewHolder.linearLayout.setOnClickListener {
            if (rowIndex != position) {
                rowIndex = position
                viewModel.selectedCategory.postValue(categoryList[position].categoryName)
                notifyDataSetChanged()
            }
        }

        if (rowIndex == position) {
            viewHolder.linearLayout.setBackgroundResource(R.drawable.category_selected_bg)
        } else {
            viewHolder.linearLayout.setBackgroundResource(R.drawable.category_bg)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = categoryList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val categoryView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_category, parent, false)
        return ViewHolder(categoryView)
    }

    class ItemDiffCallback(
        var oldList: List<Category>,
        var newList: List<Category>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            (oldList[oldItemPosition].categoryName == newList[newItemPosition].categoryName)

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return when {
                oldList[oldItemPosition].categoryName != newList[newItemPosition].categoryName -> false
                else -> true
            }
        }
    }

}