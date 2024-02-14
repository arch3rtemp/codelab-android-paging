package com.example.android.codelabs.paging.ui.adapter.drawer

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.android.codelabs.paging.R
import com.example.android.codelabs.paging.databinding.SeparatorViewItemBinding
import com.example.android.codelabs.paging.ui.UiModel
import com.example.android.codelabs.paging.ui.adapter.viewholder.SeparatorViewHolder
import com.example.android.codelabs.paging.ui.common.CommonViewHolder
import com.example.android.codelabs.paging.ui.common.ItemDrawer

class SeparatorDrawer(override val model: UiModel) : ItemDrawer {
    override fun createViewHolder(parent: ViewGroup): CommonViewHolder<UiModel> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.separator_view_item, parent, false)
        val binding = SeparatorViewItemBinding.bind(view)
        return SeparatorViewHolder(binding)
    }

    override fun bind(holder: CommonViewHolder<UiModel>, listener: (UiModel) -> Unit) {
        holder.setData(model, listener)
    }

    override fun compareByItems(newItem: ItemDrawer): Boolean {
        return if (model is UiModel.SeparatorItem && newItem.model is UiModel.SeparatorItem) {
            model.description == (newItem.model as UiModel.SeparatorItem).description
        } else false
    }

    override fun compareByContent(newItem: ItemDrawer): Boolean {
        return if (model is UiModel.SeparatorItem && newItem.model is UiModel.SeparatorItem) {
            model.description == (newItem.model as UiModel.SeparatorItem).description
        } else false
    }
}