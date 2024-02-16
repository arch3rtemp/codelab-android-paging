package com.example.android.codelabs.paging.ui.adapter.drawer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.android.codelabs.paging.R
import com.example.android.codelabs.paging.databinding.SeparatorViewItemBinding
import com.example.android.codelabs.paging.ui.UiModel
import com.example.android.codelabs.paging.ui.adapter.viewholder.SeparatorViewHolder
import com.example.android.codelabs.paging.ui.common.CommonViewHolder
import com.example.android.codelabs.paging.ui.common.ItemDrawer

class SeparatorDrawer : ItemDrawer<SeparatorViewItemBinding, UiModel.SeparatorItem> {

    override fun isProperItem(item: UiModel) = item is UiModel.SeparatorItem

    override fun getLayoutId() = R.layout.separator_view_item

    override fun getViewHolder(
        layoutInflater: LayoutInflater,
        parent: ViewGroup
    ): CommonViewHolder<SeparatorViewItemBinding, UiModel.SeparatorItem> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.separator_view_item, parent, false)
        val binding = SeparatorViewItemBinding.bind(view)

        return SeparatorViewHolder(binding)
    }

    override fun getDiffUtil() = object : DiffUtil.ItemCallback<UiModel.SeparatorItem>() {
        override fun areItemsTheSame(oldItem: UiModel.SeparatorItem, newItem: UiModel.SeparatorItem) =
            oldItem.description == newItem.description

        override fun areContentsTheSame(oldItem: UiModel.SeparatorItem, newItem: UiModel.SeparatorItem) =
            oldItem.description == newItem.description
    }
}