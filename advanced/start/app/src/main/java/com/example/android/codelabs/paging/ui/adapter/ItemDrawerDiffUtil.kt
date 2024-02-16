package com.example.android.codelabs.paging.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.android.codelabs.paging.ui.UiModel
import com.example.android.codelabs.paging.ui.common.ItemDrawer

class ItemDrawerDiffUtil(private val drawers: List<ItemDrawer<*, *>>) : DiffUtil.ItemCallback<UiModel>() {
    override fun areItemsTheSame(oldItem: UiModel, newItem: UiModel): Boolean {
        if (oldItem::class != newItem::class) return false

        return getItemCallback(oldItem).areItemsTheSame(oldItem, newItem)
    }

    override fun areContentsTheSame(oldItem: UiModel, newItem: UiModel): Boolean {
        if (oldItem::class != newItem::class) return false

        return getItemCallback(oldItem).areContentsTheSame(oldItem, newItem)
    }

    private fun getItemCallback(item: UiModel): DiffUtil.ItemCallback<UiModel> {
        return drawers
            .find { drawer -> drawer.isProperItem(item) }
            ?.getDiffUtil()
            ?.let { it as DiffUtil.ItemCallback<UiModel> }
            ?: throw IllegalArgumentException("DiffUtil not found for $item")
    }
}