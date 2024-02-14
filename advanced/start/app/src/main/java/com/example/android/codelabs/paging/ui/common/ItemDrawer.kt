package com.example.android.codelabs.paging.ui.common

import android.view.ViewGroup
import com.example.android.codelabs.paging.ui.UiModel

interface ItemDrawer {
    val model: UiModel
    fun createViewHolder(parent: ViewGroup): CommonViewHolder<UiModel>
    fun bind(holder: CommonViewHolder<UiModel>, listener: (UiModel) -> Unit)
    fun compareByItems(newItem: ItemDrawer): Boolean
    fun compareByContent(newItem: ItemDrawer): Boolean
}