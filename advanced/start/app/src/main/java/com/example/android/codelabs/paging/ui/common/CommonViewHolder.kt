package com.example.android.codelabs.paging.ui.common

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.android.codelabs.paging.ui.UiModel

abstract class CommonViewHolder<out Binding : ViewBinding, Item : UiModel>(
    val binding: Binding
) : RecyclerView.ViewHolder(binding.root) {

    lateinit var item: Item

    open fun onBind(item: Item) {
        this.item = item
    }
}
