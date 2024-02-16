package com.example.android.codelabs.paging.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding
import com.example.android.codelabs.paging.ui.UiModel

interface ItemDrawer<Binding : ViewBinding, Item : UiModel> {

    fun isProperItem(item: UiModel): Boolean

    @LayoutRes
    fun getLayoutId(): Int

    fun getViewHolder(layoutInflater: LayoutInflater, parent: ViewGroup): CommonViewHolder<Binding, Item>

    fun getDiffUtil(): DiffUtil.ItemCallback<Item>
}